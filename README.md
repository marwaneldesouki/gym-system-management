# Project Title
- Gym-System-Management with java Jframe + SQLite

## Database used
-	SQLite

## Libraries used
- sqlitejdbc-v056
- jcalendar-1.4
- joda-time-2.10.8

## Requirements
-	java installed in pc

## Description
- this gym system management contains 3 dashboards

  - admin dashboard
    ![image](https://user-images.githubusercontent.com/37198610/181570991-24689c7c-14d6-46e1-aabc-c1a613a863e8.png)
  - coach dashboard
    ![image](https://user-images.githubusercontent.com/37198610/181571076-7dba826d-4d5a-448f-a4fe-ca736e7df039.png)

  - member dashboard
    ![image](https://user-images.githubusercontent.com/37198610/181571130-f61f1dc5-e657-4cd5-8ccc-29402fc6bcc9.png)

  - login form
    ![image](https://user-images.githubusercontent.com/37198610/181570930-5193242d-229b-4f83-81a3-d07e26ef85b3.png)

  
## the options of ADMIN dashboard can

  - add coach
    ![image](https://user-images.githubusercontent.com/37198610/181571395-23d38202-3437-46ab-bd1b-3fcd466e840b.png)

  - add notification
    ![image](https://user-images.githubusercontent.com/37198610/181571559-86590ab2-11ae-46ff-abd5-a9403bacee62.png)

  - see total payment
    ![image](https://user-images.githubusercontent.com/37198610/181571575-266722e1-e80c-470b-a006-7cad404916e0.png)

  - see total members
       ![image](https://user-images.githubusercontent.com/37198610/181571589-5c917a25-bf2d-497c-a46c-8dd97cb86c17.png)

  - see total coaches
    ![image](https://user-images.githubusercontent.com/37198610/181571611-7556720f-e3bb-4b0c-9385-a10f1c8b6a07.png)

  - ban users
    ![image](https://user-images.githubusercontent.com/37198610/181571658-6cb59552-97f8-4544-bd7e-2560922e3d38.png)

## the options of COACH dashboard can

  - see total users
  - total payment
  - total expired memberships
  - add new user and u can choose the type of membership(1 month,6 months,1 year)
  - add schedule to members
  - show/edit/delete schedule
  - ban users
## the options of MEMBER dashboard can 
  -see his own schedule
  -settings to change his own informations
  -payment to pay the recipte of the membership to show his own schedule
 


## How it work ?
•	at first the (data_set_maker) script open the camera and take 10 images to the person and automatic crop the image to the face only
 ![image](https://user-images.githubusercontent.com/37198610/181282326-a96a8d76-e758-4e26-bb1c-d09b494cd223.png)

•	Then the (main) script Find and manipulate facial features in pictures Get the locations and outlines of each person’s eyes, nose, mouth and chin.

 ![image](https://user-images.githubusercontent.com/37198610/181284463-d038d828-b857-40d7-bed9-bccb966cd4ba.png)

•	Then eyes, nose, mouth and chin it`s called futures so the futures are taken to compare it with other futures to every person in dataset ,and when it match then it can recognize the face in image.
 ![image](https://user-images.githubusercontent.com/37198610/181284617-dae03a9e-1fd7-41a3-81b6-fcceb4018db6.png)



## HOW TO USE
 • make your own dataset by data_set_maker.py
 make sure to add more than 10 models to make a perfect train
 •run main.py and wait until the training end then the camera or the screen capture will open

## Developer
marwan eldesouki
