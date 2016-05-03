# Jiansen's NOTE
- Started using the [Play Java Seed code template](http://www.lightbend.com/activator/template/play-java)
- Run and test using Activator UI
- Screenshots of tests running on my PC is saved in the screen folder

# Qudini web developer code test

To test how quickly you can pick up a new project and follow requirements we ask candidates to do the following project (in either Play 1.2.7 or Play 2) that meets the following requirements:

- Fork this project
- Start a new Play framework app
- Provide an API which accepts a list of json 'customer' objects in the body of a POST request (see json example attached).
- The API should take this list of objects and sort them by due time then return this back as a sorted json array.
- Should use the Joda time (http://www.joda.org/joda-time/) library to handle times with timezones.  
- The API should be non-blocking and be as efficient as possible in its sorting.
- We'll test this by load testing the project with a few hundred users to see how it performs (if you have time try using Jmeter to test your implementation).

Bonus points:

- An API is great, but how about adding some UI for easy upload of the file.


