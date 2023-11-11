import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestRegressor
from sklearn.preprocessing import StandardScaler, OneHotEncoder
from sklearn.compose import ColumnTransformer
from sklearn.pipeline import Pipeline
import variable as vb

def get_predict(file_path):
    # Load the dataset

    data = pd.read_csv(file_path)

    # Preprocess the data
    # Encoding categorical variables
    categorical_features = ['typ_transakcie', 'popis','terminal_id','financny_tok']
    numerical_features = ['suma']

    # Creating a column transformer
    preprocessor = ColumnTransformer(
        transformers=[
            ('num', StandardScaler(), numerical_features),
            ('cat', OneHotEncoder(), categorical_features)
        ]
    )

    # Splitting the data
    X = data[categorical_features + numerical_features]
    y = data['stav_po']
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

    # Model Pipeline
    model = Pipeline(steps=[('preprocessor', preprocessor),
                            ('regressor', RandomForestRegressor())])

    # Training the model
    model.fit(X_train, y_train)

    # Making predictions for the next 6 months
    # Here you need to provide the new data for the next 6 months
    # For demonstration, let's use the last 6 rows of X_test
    new_data = X_test.tail(350)
    predictions = model.predict(new_data)

    # Output the predictions
    # print(predictions)
    counter = 0

    c = round(len(predictions) / 8);


    kk=0
    p = 0;
    # print(len(predictions))

    mesiace = ["Nov-23", "Dec-23", "Jan-24", "Feb-24", "Mar-24", "Apr-24", "Maj-24"]

    fr=[]

    response = dict.fromkeys(
        ["mesiac", "stav_uctu"])

    for row in predictions:
        if counter == c:

            response['mesiac'] = mesiace[p]
            p=p+1
            response['stav_uctu'] = round(row,2)
            print(round(row,2))
            kk=kk+1
            if(kk == 7):
                break
            fr.append(response.copy())
            response = vb.del_dict(response)

            counter = 0
        counter = counter + 1

    return fr
