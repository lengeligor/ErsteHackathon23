import variable as vb
from operator import itemgetter
from datetime import datetime



def get_normalize_data(data,file):
    sorted_trans = sorted(data, key=itemgetter("datum_cas"))
    init_suma = 900;
    for row in data:

        row['stav_pred'] = init_suma
        if row['financny_tok'] == '+':
            init_suma = round(init_suma +  float(row['suma']),2)
        else:
            init_suma = round(init_suma -  float(row['suma']),2)

        row['stav_po'] = str(init_suma)

    vb.write_to_csv(file, data)
    return data
