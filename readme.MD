 DB tables
customer(cId number(6) primary key ,cName varchar2(20) not null)
Address(zipcode varchar2(10) primary key,street varchar2(15),area varchar2(15),district varchar2(15) not null)
order(oId number(8) primary key, oName varchar2(25) not null , cId number(6)
foreign key(cId) references customer(cId));