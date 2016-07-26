CREATE TABLE IF NOT EXISTS "person" (
  id            integer PRIMARY KEY,
  firstName           VARCHAR,
  lastName            VARCHAR,
  title               VARCHAR,
  background          VARCHAR,
  linkedinUrl         VARCHAR,
  avatarUrl           VARCHAR,
  companyId           integer,
  companyName         VARCHAR,
  createdAt           VARCHAR,
  updatedAt           VARCHAR,
  visibleTo           VARCHAR,
  authorId            integer,
  groupId             integer,
  ownerId             integer
);

CREATE TABLE IF NOT EXISTS "tag" (
  id               integer PRIMARY KEY,
  name                VARCHAR
);

CREATE TABLE IF NOT EXISTS "persontag" (
  id                  SERIAL PRIMARY KEY,
  personId            integer,
  tagId               integer,
  constraint fk_persontag_person
  foreign key (personId)
  REFERENCES person (id),

  constraint fk_persontag_tag
  foreign key (tagId)
  REFERENCES tag (id)
);