# GroupProjectForCodePath - *TravelLog*

**TravelLog** is an android app that allows a user to plan, track and share his/her trip. It is not just a tool for better trip planning, but an album for your best memory.

Time spent: **X** hours spent in total

## User Stories

The following **required** functionality is completed:

* [ ]	User can **sign in to Facebook** using OAuth login
* [ ]	User can **view trips from their home timeline**
  * [ ] User is displayed the trip title, status and participants for each trip
  * [ ] User can view more trips as they scroll with [infinite pagination](http://guides.codepath.com/android/Endless-Scrolling-with-AdapterViews-and-RecyclerView). Number of trips is unlimited.
* [ ]   User can also switch to **view trips shared by their friends**
  * [ ] User should be able to click into the trip and see a summary of the trip.
  * [ ] User should NOT be allowed to edit anything on their friends trip.
* [ ] User can **create a new trip**
  * [ ] User can click a “Start” icon in the Action Bar on the top right
  * [ ] User can then enter when to start and end the trip, who will attend and add a title for the trip
  * [ ] User is taken to a new trip page with a list of days generated base on how long this trip will take.
  * [ ] User can click into each day to fill the detail of the trip like the place to go, the things to do.
  * [ ] User can always eidt the time(add and remove days from new trip page) and participants of this trip.
* [ ]  User can "publish" their trip so the trip is visible for their friend.

The following **optional** features are implemented:

* [ ] User can **Add photos to their daily trip detail** on each day's page of the trip
* [ ] User can **View the destination on the map**
* [ ] User can Share their locations on the map

The following **bonus** features are implemented:

* [ ] User can view the local cached trip lists when internet connect is unavailable

The following **additional** features are implemented:

* [ ] User can upload .pdf file to their trips.
* [ ] User can "look around" on the app to find the user close to them and make friend request.

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
