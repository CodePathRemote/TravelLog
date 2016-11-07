# GroupProjectForCodePath - *TravelLog*

**TravelLog** is an android app that allows a user to plan, track and share his/her trip. It is not just a tool for better trip planning, but an album for your best memory.

Time spent: **X** hours spent in total

## User Stories

The following **required** functionality is completed:
* [ ] When our app is initialized and in the loading stage, a **logo screen** will be shown to user before redirected to login page. 
* [ ]	User can **sign in to Facebook** using OAuth login
* [ ]	User can **view map view of the current trip** after user login
  * [ ] User is displayed with the map view of the most recently created trip.
  * [ ] User is given a bottom navigation bar which can direct the user to most frequently used pages like Photos, Notes, Budget and CarService.
  * [ ] User is given links to other pages by click the hamburger botton at top navigation bar.
  * [ ] User is given a floating action bar to share the trip.
* [ ] User can **take photos** at photo taken page.
  * [ ] User should be given the choice of save or cancel the taken photo.
  * [ ] The photo should be pined at the map based on the location info stored.
* [ ] User can **take notes** at notes taken page.
  * [ ] User should be given the choice of save or cancel the notes.
  * [ ] The user should be able to edit the saved notes at anytime.
* [ ] User can **put down expenses** at budget page.
  * [ ] User should be able to put down the amount and category of the expense.
  * [ ] The app will help user track the total expense for each trip.
* [ ] User can **create a new trip**
  * [ ] User can enter the total days of trip.
  * [ ] User can enter one trip destination address.
  * [ ] User can enter the participants of the trip.
  * [ ] User is redirected back to the map view after the trip is created.
  * [ ] User can always eidt the time, destination and participants of the trip.
* [ ] User can **view/edit** their own profile.
* [ ] User can **view all the existing trips** created in the view trips page. 

The following **optional** features are implemented:

* [ ] The main **map view** is auto scoped based on the activities(photos, pins) of the user.
* [ ] User can "share" their trips to their facebook friends. The sharee can view the trips shared to him/her.
* [ ] User can **pin multiple locations** for each trip.
* [ ] User can **View** the trip participants' profile if they are friends on facebook.

The following **bonus** features are implemented:

* [ ] User can view the local cached trip map view when internet connect is unavailable

The following **additional** features are implemented:

* [ ] To be decided.

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='http://i.imgur.com/link/to/your/gif/file.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

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
