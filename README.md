# Board
Task: Implement Agile board.
Use: Spring, mongoDB, ReactJS (optional)
User story: I log in to the web app and see 3 columns on the page: TO DO, In Progress, Done. I need to be able to: add/remove ticket in any column
Edit ticket (ticket has 2 fields: name and description). Move ticket to any another column


--mongoDB setup, before first application run--
db board
db.sequences.insert({
    "_id" : "users",
    "sequence" : 0
})

db.sequences.insert({
    "_id" : "tickets",
    "sequence" : 0
})