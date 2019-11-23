$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Assignment.feature");
formatter.feature({
  "line": 1,
  "name": "Search top 250 movies in IMDB website",
  "description": "",
  "id": "search-top-250-movies-in-imdb-website",
  "keyword": "Feature"
});
formatter.before({
  "duration": 4780064500,
  "status": "passed"
});
formatter.scenario({
  "line": 2,
  "name": "Search top 250 movies in IMDB website",
  "description": "",
  "id": "search-top-250-movies-in-imdb-website;search-top-250-movies-in-imdb-website",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "user navigates to imdb home page",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "user gets top 250 movies list",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "user verifies and prints the same into a text file",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeSteps.navigation()"
});
formatter.result({
  "duration": 58436320900,
  "status": "passed"
});
formatter.match({
  "location": "ChartListSteps.listOfMovies()"
});
formatter.result({
  "duration": 6820340800,
  "status": "passed"
});
formatter.match({
  "location": "ChartListSteps.printListOfMovies()"
});
formatter.result({
  "duration": 11367386300,
  "status": "passed"
});
formatter.after({
  "duration": 1326806100,
  "status": "passed"
});
});