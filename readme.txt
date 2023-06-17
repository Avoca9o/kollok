Чтобы поднять базу данных в постгресе нужно создать сервер
с именем demo на порту 5432

дальше описать в нем следующее:

demo=# CREATE DATABASE kollok;
CREATE DATABASE
demo=# grant all privileges on database "kollok" to <username>;
GRANT
demo=# grant all privileges on database "kollok" to postgres;
GRANT
demo=#