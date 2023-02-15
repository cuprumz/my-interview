CREATE TABLE `hero` (
  `number` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into hero(number, name, country ) values(21, 'abc', 'China');
insert into hero(number, name, country ) values(33, 'jon', 'America');