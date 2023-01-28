INSERT INTO _users (email, password, enabled, role, created_at, updated_at)
values ('blimo@teckmils.com','pass',1, 'admin', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO authorities (email, authority)
values ('blimo@teckmils.com', 'write');