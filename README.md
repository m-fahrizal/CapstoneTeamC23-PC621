<h1 align="center">MyKIP</h1>

###

<h2 align="center">Bangkit 2023 Capstone Project</h2>

###

<h3 align="center">Team ID : C23-PC621</h3>



<br clear="both">

<div align="center">

  ID|Name|Path|
  ---|---|---|
  M308DSX1890|Gede Wahyu Purnama|Machine Learning
  M132DSX2849|Daffa Hafiizh Permadi|Machine Learning
  M257DSX0044|Daffa Arifadilah|Machine Learning
  C040DSX1623|Muhammad Nabil Azizi|Cloud Computing
  C304DSX1959|Arya Nur Hidayat|Cloud Computing
  A304DSX1262|Muhammad Fahrizal|Android Development
  
</div>

<p align="center">Theme : Education, Learning, and Personal Development</p>

###

<h3 align="center">About Project</h3>

###

<p align="justify">The MyKIP project is our initiative where there are still many students who do not get the KIP (Kartu Indonesia Pintar) scholarship as they should, where this project will help the selection process so that prospective KIP (Kartu Indonesia Pintar) scholarship recipients can be declared eligible or not to receive the scholarship, with the prediction of high school students who want to register themselves to get the KIP (Kartu Indonesia Pintar) Scholarship provided by the government. The system built in the form of an android application with features: detecting students with what kind of economic level deserves the KIP Scholarship (Kartu Indonesia Pintar) using the machine learning process of classification student home photos and student data.</p>

###

<h3 align="center">Tech Stack</h3>

###

<div align="center">
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/androidstudio/androidstudio-original.svg" height="40" alt="androidstudio logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/kotlin/kotlin-original.svg" height="40" alt="kotlin logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/firebase/firebase-plain.svg" height="40" alt="firebase logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/tensorflow/tensorflow-original.svg" height="40" alt="tensorflow logo"  />
  <img width="12" />
  <img src="https://upload.wikimedia.org/wikipedia/commons/d/d0/Google_Colaboratory_SVG_Logo.svg" height="40" alt="GColab logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/googlecloud/googlecloud-original.svg" height="40" alt="googlecloud logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/nodejs/nodejs-original.svg" height="40" alt="nodejs logo"  />
  <img width="12" />
  <img src="https://www.vectorlogo.zone/logos/pocoo_flask/pocoo_flask-ar21.png" height="40" alt="flask logo"  />
</div>

<div align="center">
  <h3>Screenshot</h3>

  <img src="https://github.com/yunama47/CapstoneTeamC23-PC621/blob/main/Capstone%20Assets/home.jpg?raw=true" width="250" height="550">&nbsp; &nbsp;
  <img src="https://github.com/yunama47/CapstoneTeamC23-PC621/blob/main/Capstone%20Assets/apply.jpg?raw=true" width="250" height="550">&nbsp; &nbsp;
  <img src="https://github.com/yunama47/CapstoneTeamC23-PC621/blob/main/Capstone%20Assets/profile.jpg?raw=true" width="250" height="550">&nbsp; &nbsp;
</div>


<h2 align="center">Machine Learning</h3>

###

  ## Datasets

  Sample student data : </br>
  We got our sample students dataset from [this article.](https://www.iocscience.org/ejournal/index.php/mantik/article/view/3536/2601)

  Synthesis student data : <br/>
  We synthetize student data for training dataset for our model using [mostly ai.](https://synthetic.mostly.ai/)

  House Images : 
  * Google Images (web scraping using [Google-Image-Scraper](https://github.com/ohyicong/Google-Image-Scraper))
  * Screenshots from Google Street View
  * Own Picture
<br/><br/>
## KIP Classification Model

<img src='https://github.com/yunama47/CapstoneTeamC23-PC621/raw/main/Capstone%20Assets/model-architecture.jpg'>

###
---
<h2 align="center">Cloud Computing</h3>

###

## Tech Stack

| [Node.js](https://nodejs.org/) | [Flask](https://flask.palletsprojects.com/en/2.3.x/)|[My SQL](https://www.mysql.com/) |
|:---:|:---:|:---:|
|**[Cloud SQL](https://cloud.google.com/sql)** |**[Cloud Storage](https://cloud.google.com/storage)** |**[App Engine](https://cloud.google.com/appengine)** |
|**[Cloud Functions](https://cloud.google.com/functions)** 

###

## Cloud Infrastructure
<div align="center">
  <img src='https://github.com/NabilAzizii/API-Cloud-Computing/assets/128737322/cd46bea0-72a6-4ca3-9e8f-fdba3a423390'>
</div>

## API and Deployment
  1. Create [Google Cloud Platform](https://cloud.google.com/) Project
  2. Create a [App Engine](https://cloud.google.com/appengine), [Cloud SQL](https://cloud.google.com/sql) [My SQL](https://www.mysql.com/), 2 [Cloud Storage](https://cloud.google.com/storage) (FotoRumah and MLModel)
  3. Create a service account in order to access [Cloud SQL](https://cloud.google.com/sql) and [Cloud Storage](https://cloud.google.com/storage) ( **Please note the access given** )
  
  **API Database**
  
  4. Build API for Database with Node JS in Google Cloud Shell (Method **POST,GET,DELETE**)
  5. Integrate API for Database to [Cloud SQL](https://cloud.google.com/sql) [My SQL](https://www.mysql.com/) and [Cloud Storage](https://cloud.google.com/storage)
  6. Deploy To [App Engine](https://cloud.google.com/appengine) (`gcloud app deploy` on google cloud shell)
  
  **API Machine Learning**
  
  7. Put the model that has been created by the machine learning team into google storage (MLModel)
  8. Build API Machine Learning with Flask in inline code editor **Cloud Functions** (Method **POST**)
  9. Change Entrypoint same in the main.py
  10. Make sure requirements.txt is the same as the enviroment used in main.py
  11. Deploy to [Cloud Functions](https://cloud.google.com/functions) (`click "Deploy"`)
  
  **Testing API**
  
  12. Using [Postman](https://www.postman.com/) to test a deployed api
  13. For API Database Use URL in App Engine (*example: https://[Project_ID].et.r.appspot.com*)
  14. Change Method to `POST` to create new Students Data to Database
  15. Change to `Body` and to `raw` and change the Request type using `JSON`
  16. Create the required JSON
  17. Then *click* `SEND`
  18. For API Machine Learning Use Trigger in Cloud Functions (*example: https://[region]-[Project_ID].cloudfunctions.net/[entrypoint]*)
  19. Change to `Body` and to `raw` and change the Request type using `JSON`
  20. Create the required JSON
  21. Then *click* `SEND`
  
  #### Build with Love by [Muhammad Nabil Azizi](https://www.linkedin.com/in/muhammad-nabil-azizi-6a180a164/) and [Arya Nur Hidayat](https://www.linkedin.com/in/arya-nur-hidayat-ba26081b8/) as a Cloud Team ❤
  
