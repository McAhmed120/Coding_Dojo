SELECT * FROM world.countries;

SELECT countries.name ,languages.language ,languages.percentage from countries JOIN languages 
ON countries.id=languages.country_id WHERE languages.language="Slovene" ORDER BY languages.percentage DESC;

SELECT countries.name , COUNT(cities.name) AS num_cities  from world.countries JOIN world.cities ON countries.id=cities.country_id 
GROUP BY countries.name
ORDER BY num_cities DESC ;

SELECT cities.name , cities.population  from world.countries JOIN world.cities ON countries.id=cities.country_id
WHERE countries.name="MEXICO" AND cities.population>500000 ORDER BY cities.population DESC ;

SELECT countries.name ,languages.language ,languages.percentage from countries JOIN languages 
ON countries.id=languages.country_id WHERE languages.percentage>89 ORDER BY languages.percentage DESC;

SELECT countries.name ,countries.surface_area ,cities.population from world.countries JOIN world.cities ON countries.id=cities.country_id
WHERE cities.population>100000 AND countries.surface_area<501 
ORDER BY cities.population;
SELECT countries.name from world.countries WHERE countries.government_form="Constitutional Monarchy" AND countries.capital>200 AND countries.life_expectancy>75 ;


SELECT countries.name as country_name, cities.name as city_name ,cities.district, cities.population  from world.countries JOIN world.cities ON countries.id=cities.country_id
WHERE countries.name="Argentina" AND cities.population>500000 AND cities.district="buenos aires";
SELECT countries.region, count(countries.name) as countries_num FROM countries GROUP BY countries.region ORDER BY countries_num DESC;
