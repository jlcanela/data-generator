# Data Generator

This project is a basic data generator written in Spark. 
* it read generates a folder with campaign files as text files

Example of the folder: 
```
folder 
  +--- campaign001.txt
  +--- campaign002.txt
  ...
  +--- campaign<n>.txt
```

The campaign fields are:
* location: geographic location used to trigger the ad, https://en.wikipedia.org/wiki/ISO_3166-1_alpha-3#Officially_assigned_code_elements
* name: name of campaign defined by the marketing team
* id: unique identifier of the campaign, automatically defined (num auto, guid)
* startDateTime: the campaign starts at startDateTime
* endDateTime: the campaign ends at endDateTime
* segments: defined by marketing team, could be age ranges

List of allowed segments:
* AGE: AGE_0_17, AGE_18_20, AGE_21_100
* GENDER: GENDER_M, GENDER_F, GENDER_BOTH


format of startDateTime and endDateTime is "DDM-MY-YYY HH:mm:ss"
- local date time ? 
- or is there a timezone ? 

scenario: 
- A marketing team in Tokyo starts the campaign january the 1st 2022 at 00:00
- A marketing team in Paris starts the campaign january the 1st 2022 at 00:00

Ana’s proposal
- UTC time with ISO Format, example 2022-12-16T12:06:17Z


A campaign file content is: 
```
location,name,id,startDateTime,endDateTime,segments
FRA,campaign1,12345,2022-01-16T12:06:17Z,2022-02-16T12:06:17Z,AGE_18_20;GENDER_BOTH
```


# Run the project 

To run the project:
```
git clone git@github.com:jlcanela/data-generator.git
cd data-generator
./mill datagenerator.standalone.run generate data/campaigns
```

# Tools used 

mill: https://com-lihaoyi.github.io/mill/mill/Intro_to_Mill.html

