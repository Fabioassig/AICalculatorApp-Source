CREATE TABLE IF NOT EXISTS release_info (
    id INTEGER PRIMARY KEY,
    app_name TEXT NOT NULL,
    version TEXT NOT NULL,
    release_status TEXT NOT NULL
);
