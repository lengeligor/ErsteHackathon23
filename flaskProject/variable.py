import csv

COMPETITIONS_LIST = {"BML": "RUN",
                     "BMH": "HDC",
                     "BMR": "WHL"}


def get_file(file_csv):
    try:
        country_list = []
        with open(file_csv, 'r', encoding='utf-8') as csv_file:
            # Create a CSV reader
            csv_reader = csv.DictReader(csv_file)

            for line in csv_reader:
                # Remove leading and trailing whitespace and add it to the list
                country_list.append(line)

            return country_list

    except FileNotFoundError:
        print(f"File {file_csv} not found.")
    except Exception as e:
        print(f"An error occurred: {e}")


def get_country():
    country_csv = "country/country2.csv"

    try:
        country_list = []
        with open(country_csv, 'r', encoding='utf-8') as csv_file:
            # Create a CSV reader
            csv_reader = csv.DictReader(csv_file)

            for line in csv_reader:
                # Remove leading and trailing whitespace and add it to the list
                country_list.append(line)

            return country_list

    except FileNotFoundError:
        print(f"File {country_csv} not found.")
    except Exception as e:
        print(f"An error occurred: {e}")


def get_country_from_file(country_csv):

    try:
        country_list = []
        with open(country_csv, 'r', encoding='utf-8') as csv_file:
            # Create a CSV reader
            csv_reader = csv.DictReader(csv_file)

            for line in csv_reader:
                # Remove leading and trailing whitespace and add it to the list
                country_list.append(line)

            return country_list

    except FileNotFoundError:
        print(f"File {country_csv} not found.")
    except Exception as e:
        print(f"An error occurred: {e}")



def get_country_code(country, code):
    for line in country:
        if line["origin"] == code:
            return line["code"]
    return "NoN"


def get_competition(key):
    if key in COMPETITIONS_LIST:
        return COMPETITIONS_LIST[key]
    else:
        return None


def get_division(year, birth_year, origin_division):
    if birth_year == "0":
        return None

    person_year = int(year) - int(birth_year)

    if person_year < 15:
        return "U15"
    elif 15 <= person_year <= 19:
        return "15"
    elif 20 <= person_year <= 24:
        return "20"
    elif 25 <= person_year <= 29:
        return "25"
    elif 30 <= person_year <= 34:
        return "30"
    elif 35 <= person_year <= 39:
        return "35"
    elif 40 <= person_year <= 44:
        return "40"
    elif 45 <= person_year <= 49:
        return "45"
    elif 50 <= person_year <= 54:
        return "50"
    elif 55 <= person_year <= 59:
        return "55"
    elif 60 <= person_year <= 64:
        return "60"
    elif 65 <= person_year <= 69:
        return "65"
    elif 70 <= person_year <= 74:
        return "70"
    elif 75 <= person_year <= 79:
        return "75"
    elif 80 <= person_year <= 84:
        return "80"
    elif person_year > 84:
        return "O84"
    else:
        return None


def write_to_csv(csv_file, records):
    with open(csv_file, 'w', newline='', encoding='utf-8') as file:
        fieldnames = records[0].keys()  # Použijte klíče prvního záznamu pro záhlaví
        writer = csv.DictWriter(file, fieldnames=fieldnames)

        # Zapište záhlaví (názvy klíčů) do souboru CSV
        writer.writeheader()

        # Zapište obsah seznamu do souboru CSV
        for record in records:
            writer.writerow(record)

    print(f"Seznam byl zapsán do souboru {csv_file}")


def del_dict(dict):
    for key in dict:
        dict[key] = None
    return dict
