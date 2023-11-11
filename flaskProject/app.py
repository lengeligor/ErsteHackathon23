from flask import Flask, request
import variable as vb
import  normalize as nm
import testik as ts
import numpy as np

app = Flask(__name__)

def get_not_no_filter(data):
    response = []
    for row in data:
        response.append(row.copy())

    f="data/no_filter.csv"
    nm.get_normalize_data(response,f)
    return ts.get_predict(f)

def get_not_netflix(data):
    response = []
    for row in data:
        if row['popis'] != "Netflix":
            response.append(row.copy())
    f="data/netflix.csv"
    nm.get_normalize_data(response,f)
    return ts.get_predict(f)

def get_not_Disney(data):
    response = []
    for row in data:
        if row['popis'] != "Disney Plus":
            response.append(row.copy())

    f = "data/disney.csv"
    nm.get_normalize_data(response, f)
    return ts.get_predict(f)


def get_half_hazard(data):
    response = []
    for row in data:
        if row['popis'] == "Hazardné hry":

            k=row.copy()

            k['suma'] = str(round(float(row['suma']) / 2.0))

            response.append(k.copy())
        else:

            response.append(row.copy())

    f = "data/halfHazard.csv"
    nm.get_normalize_data(response, f)
    return ts.get_predict(f)

def get_less_shopping(data):
    response = []
    p=0
    for row in data:
        if str(row['popis']) == "Potraviny":
            if p != 5:
                response.append(row.copy())
            else:
                p=0
            p=p+1;
        else:
            response.append(row.copy())

    f = "data/lessShoping.csv"
    nm.get_normalize_data(response, f)
    return ts.get_predict(f)


# data = vb.get_file("data/transaction.csv")
# print("no_filter")
# get_not_no_filter(data)
#
#
# print("no_netflix")
# get_not_netflix(data)
#
# print("no_disney")
# get_not_Disney(data)
#
#
#
#
# print("less_shoping")
# get_less_shopping(data)
#
# print("half_hazard")
# get_half_hazard(data)


@app.route('/')
def hello_world():  # put application's code here
    return 'Hello World!'

@app.route('/api/graph', methods=["GET"])
def add_new_year():
    response_final=[]
    response = dict.fromkeys(
        ["graphType", "graphs"])

    data = vb.get_file("data/transaction.csv")
    print("no_filter")
    response['graphs'] = get_not_no_filter(data)
    response['graphType'] = "Doterajšie srávanie"

    response_final.append(response.copy())
    response=vb.del_dict(response)

    print("no_netflix")
    response['graphs'] =get_not_netflix(data)
    response['graphType'] = "Bez Netflixu"

    response_final.append(response.copy())
    response = vb.del_dict(response)

    print("no_disney")
    response['graphs'] =get_not_Disney(data)
    response['graphType'] = "Bez Disney plus"

    response_final.append(response.copy())
    response = vb.del_dict(response)

    print("less_shoping")
    response['graphs'] =get_less_shopping(data)
    response['graphType'] = "Lepšie potravinové hospodárenie"

    response_final.append(response.copy())
    response = vb.del_dict(response)

    print("half_hazard")
    response['graphs'] =get_half_hazard(data)
    response['graphType'] = "Obmedzenie hazardu"

    response_final.append(response.copy())
    response = vb.del_dict(response)

    seznam = []

    for rr in response_final:
        seznam.append(rr['graphs'][0]['stav_uctu'])

    priemer = np.mean(seznam)

    for rr in response_final:
        rr['graphs'][0]['stav_uctu'] = priemer

    return response_final



if __name__ == '__main__':
    app.run()
