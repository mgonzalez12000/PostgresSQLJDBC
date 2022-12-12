DROP FUNCTION IF EXISTS cd_album();
CREATE FUNCTION cd_album() RETURNS REAL AS
'
DECLARE
    count_cd REAL;
    total_count REAL;
BEGIN
    SELECT COUNT(*) INTO count_cd 
    FROM album 
    WHERE format = ''CD'' OR format = ''cd'';
	SELECT COUNT(*) INTO total_count 
    FROM album;
    RETURN count_cd/total_count * 100;
END;
'
LANGUAGE 'plpgsql'


DROP FUNCTION IF EXISTS total_songs();
CREATE FUNCTION total_songs() RETURNS INTEGER AS
'
DECLARE
	counter INTEGER;
BEGIN
	SELECT COUNT(*) INTO counter
	FROM song;
	RETURN counter;
END;
'
LANGUAGE 'plpgsql'


CREATE OR REPLACE FUNCTION trigger_song_restrict()
RETURNS trigger AS 
'
DECLARE
	counter integer := 0;
BEGIN
	SELECT count(*) into counter
	FROM song
	WHERE album_unique_id = NEW.album_unique_id;
	
	if counter = 15
		then raise exception ''An album cant contain more than 15 songs'';
	end if;
	
	RETURN new;
END;
'
LANGUAGE 'plpgsql';

CREATE TRIGGER song_restrict
BEFORE INSERT OR UPDATE
ON song
FOR EACH ROW
EXECUTE PROCEDURE trigger_song_restrict();

