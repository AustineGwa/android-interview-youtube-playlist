# android-interview-youtube-playlist
a task for android developer to test their abilities and way of thinking

## Recommended
first take a look at the [Task](https://github.com/AliEsaAssadi/android-interview-youtube-playlist/new/master?readme=1#task)  try to solve the task and build the application.
if you stuck and facing a problem get help from google,stackoverflow try fixing it.


this project can help you at the end you can take a look at the sorce code and all the solution of the task.


# Task

Develop an app that get list of youtube, the list is json of movie videos and music videos.

#### #Api -> https://demo6483760.mockable.io/json.json

* Create a list view that shows each of the playlists as list items
* When a playlist item is tapped, the app should drill down and show each item
of the selected playlist with it's corresponding thumbnail image.

* When a video item is tapped, the youtube video should begin playing immediately.

We would prefer that you do not use a web view for this (use a youtube library instead).

Advice: Start with web view (or intent) and then move to a customize component.

* The user should be able to navigate back to the list view after viewing the youtube video - and continue from where he left off!!

# Solution

the app uses

#### #Architecture
* MVP 

#### #Library
* ButterKnife
* Retrofit2
* Fresco
* [ExpandableRecyclerView](https://github.com/thoughtbot/expandable-recycler-view)
* YouTubeAndroidPlayerApi

#### #Screnshot
<p align="center">
  <img src="https://i.imgur.com/zaZJbKl.png" width="250">
  <img src="https://i.imgur.com/5alnAiS.jpg" width="250">
  <img src="https://i.imgur.com/aW4IbxQ.jpg" width="250">
</p>
