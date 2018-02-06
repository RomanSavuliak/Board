# Board
<br />Task: Implement Agile board.
<br />Use: Spring, mongoDB, ReactJS (optional)
<br />User story: I log in to the web app and see 3 columns on the page: TO DO, In Progress, Done. I need to be able to: add/remove ticket in any column
<br />Edit ticket (ticket has 2 fields: name and description). Move ticket to any another column


<br />--mongoDB setup, before first application run--
<br />db board
<br />db.sequences.insert({
    "_id" : "users",
    "sequence" : 0
})
<br />db.sequences.insert({
    "_id" : "tickets",
    "sequence" : 0
})
