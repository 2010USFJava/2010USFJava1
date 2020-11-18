/*Thriving Banking Database
 * bankdata.sql 
 * Creates and populates the Banks database
 * DB Server: PostgreSql
 * Petra Maurer*/

--Create Table employee
create table employee
(
	emp_id serial primary key,
	emp_email varchar(40) not null unique,
	emp_password varchar(40) not null,
	emp_fname varchar(40) not null, 
	emp_lName varchar (40) not null,
	emp_ssn varchar(20) not null,
	emp_address varchar(80) not null,
	emp_city varchar(40) not null,
	emp_state varchar(5) not null,
	emp_zip varchar(20) not null
);

--insert values
insert into employee values
(
	default,'admin@thriving.net', 'password', 'Admin', 'Istrator', '235563756', '140 Employ Ln',
	'Miami', 'FL', '30094');

--Create Table customer
create table customer
(
	cust_id serial primary key,
	email varchar(40) not null unique,
	cust_password varchar(40) not null,
	fname varchar(40) not null, 
	lName varchar (40) not null,
	ssn varchar(20) not null,
	address varchar(80) not null,
	city varchar(40) not null,
	state varchar(5) not null,
	zip varchar(20) not null
);

--insert values
insert into customer values
(
	default,'pmaurer@gmail.com', 'Porky', 'Petra', 'Maurer', '235849756', '140 Paradise Ln',
	'Boca Raton', 'FL', '30044');
insert into customer values
(
	default,'tmaurer@gmail.com', 'love', 'Tyler', 'Maurer', '254653852', '6 Country Line',
	'Newark', 'NJ', '07101');
insert into customer values
(
	default,'nmaurer@yahoo.com', 'pizza', 'Nicholas', 'Maurer', '564743513', '53 Touring Dr',
	'Austin', 'TX', '78701');
insert into customer values
(
	default,'smaurer@comcast.com', 'Scarlett', 'Scarlett', 'Maurer', '111563214', '142 Paradise Ln',
	'Boca Raton', 'FL', '30044');
	
--Create Table account
create table account
(
	bank_account_id serial primary key,
	acct_type varchar(30),
	balance numeric,
	cust_id int,
	foreign key (cust_id) references customer on delete cascade
);

--insert account values
insert into account values(	default,'checking', 200.00, 1);
insert into account values(	default,'checking', 2354.89, 1);
insert into account values(	default,'savings', 500.00, 1);
insert into account values(	default,'checking', 624.00, 2);
insert into account values(	default,'savings', 321.85, 2);
insert into account values(	default,'checking', 600.00, 3);
insert into account values(	default,'checking', 520.00, 4);
insert into account values(	default,'checking', 10000.00, 4);

--Create Table transactions because transacgion is a key word
create table transactions
(
	transaction_id serial primary key,
	deposit numeric(30, 2),
	withdrawal numeric(30, 2),
	new_balance numeric(30, 2),
	bank_account_id int,
	foreign key (bank_account_id) references account on delete cascade	
);
	
insert into transactions values(default, 300.00, 0, 600.00,  1);
insert into transactions values(default, 0, 100, 500.00,  1);