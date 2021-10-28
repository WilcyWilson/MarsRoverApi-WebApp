## Browser view of the Mars Rover API images

![Test](test2.gif)

## What are we trying to achieve?

- When we say submit it will pass all the information about marsSol and other checkboxes in the url to the java server or backend. Java server will intercept the fact that we have rememberPreferences turned on or true. When its turned on, it can try to see if the person who has set rememberpreferences already has some id in the database already. We will store different id for different users? How do we do that?
- We will use Local Storage mechanism in javascript introduced in HTML5 long before. We will generate an id if the person doesn't already have one, in the backend in the server side in the database, and send the id back to the frontend via the model. Then we load up the model, we can store that id on the local storage, next time we press submit, it will submit that id along with the request and use that id to store data in the database.

- We are going to store the homeDto values. This is going to be our sort of a database table with a identifier for each row to uniquely identify the user.

- We are creating a user system without having username and login. We will just have it remember whichever device we are using, it will remember it on. There is no way to tie all the device in one user id unless we use username and login. It will remember the preferences for each device individually. 

## What are localStorage in javascript?

- The localStorage read-only property of the window interface allows you to access a Storage object for the Document's origin; the stored data is saved across browser sessions.

[Source Link](https://blog.logrocket.com/localstorage-javascript-complete-guide/)