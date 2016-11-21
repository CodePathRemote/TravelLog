# GroupProjectForCodePath - *TravelLog*

**TravelLog** is an android app that allows a user to plan, track and share his/her trip. It is not just a tool for better trip planning, but an album for your best memory.

**WireFrames** https://github.com/CodePathRemote/TravelLog/tree/master/wireframes

Time spent: **X** hours spent in total

## User Stories

The following **required** functionality is completed:
* [ ] When our app is initialized and in the loading stage, a **logo screen** will be shown to user before redirected to login page. 
* [ ]	User can **sign in to Facebook** using OAuth login
* [X]	User can **view map view of the current trip** after user login
  * [X] User is displayed with the map view of the current trip.
  * [X] User is given a bottom navigation bar which displays the main functionalities such as taking Photos and Notes, tracking Budget and using a CarService (More on them in the next sections)
  * [X] User is given links to other functionalities by clicking the hamburger button at top navigation bar.
  * [ ] User is given a floating action button to share the trip details
* [X] User can **take photos** on the take photo screen
  * [X] User should be given the choice of save or cancel the taken photo.
  * [X] The photo should be pined at the map based on the location info.
* [X] User can **take notes** on the take notes screen
  * [X] User should be given the choice of save or cancel the notes.
  * [ ] The note should be pined at the map based on the location info.
* [ ] User can **record expenses** on the budget screen.
  * [ ] User should be able to put down the amount and category of the expense.
  * [ ] Date of expense should be automatically added
  * [ ] The app will help user track the total expense for each trip.
* [ ] User can **create a new trip**
  * [ ] User can enter start and end date
  * [ ] User can enter name for the trip
  * [ ] User can always edit the trip information
* [ ] User can **view/edit** their own profile.
* [ ] User can **view all the existing trips** created in the view trips page. 

The following **optional** features are implemented:

* [ ] The main **map view** is auto scoped based on the activities(photos, pins) of the user.
* [ ] User can "share" their trips to their Facebook friends.
* [ ] User can **pin multiple locations** for each trip.
* [ ] User can **View** the trip participants' profile if they are friends on Facebook.

The following **bonus** features are implemented:

* [ ] User can view the local cached trip map view when internet connect is unavailable\

The following **additional** features are implemented:

* [ ] To be decided.

## Video Walkthrough

Here's a walkthrough of implemented user stories: http://i.imgur.com/R3IDVQX.mp4

<!--><img src='http://i.imgur.com/link/to/your/gif/file.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' /> -->

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

Describe any challenges encountered while building the app.

## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Picasso](http://square.github.io/picasso/) - Image loading and caching library for Android

## License

    Copyright [2016] [name of copyright owner]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
