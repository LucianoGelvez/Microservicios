db.auth('admin', 'dhbackend')

db.createUser({
  user: "user",
  pwd: "dhbackend",
  roles: [{ role: 'readWrite', db: "backend_specialization" }]
});

db.createCollection("series");
db.createCollection("catalogs");