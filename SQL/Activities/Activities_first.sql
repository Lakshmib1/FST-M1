--Activity 1
create table salesman(
salesman_id int,
salesman_name varchar2(20),
salesman_city varchar2(20),
commission int);

select * from salesman;

Describe salesman

--Activity 2
Insert into salesman values (
5001, 'James Hoog','New York', 15);

Insert into salesman values (
5002, 'Nail Knite','paris', 20);

Insert into salesman values (
5005, 'Pit Alex','London', 11);

Insert into salesman values (
5006, 'McLyon','Paris', 12);

Insert into salesman values (
5007, 'Paul Adam','Rome', 13);

Insert into salesman values (
5003, 'Lauson Hen','San Jose', 12);

--Activity 3

Select SALESMAN_ID, SALESMAN_NAME from SALESMAN

Select SALESMAN_ID, SALESMAN_NAME from Salesman
where Salesman_city = 'Paris'
or Salesman_city = 'paris';

Select SALESMAN_ID, commission from salesman

-- Activity 4

Alter table salesman
add grade int;

update salesman
set grade = 100;

--Activity 5

update salesman
set grade = 200
where salesman_city = 'Rome';

select * from salesman;

update salesman
set grade = 300
where salesman_name = 'James Hoog';

update salesman
set salesman_name = 'Pierre'
where salesman_name  = 'McLyon';

--Activity 6
-- Create a table named orders
create table orders(
    order_no int primary key, purchase_amount float, order_date date,
    customer_id int, salesman_id int);

-- Add values to the table
INSERT ALL
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005)
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001)
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003)
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002)
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001)
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001)
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006)
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003)
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002)
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007)
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001)
SELECT 1 FROM DUAL;

select * from orders

select distinct salesman_id from orders

select order_no,order_date from orders
order by order_date 

--Display the order number ordered by purchase amount in descending order
select order_no,purchase_amount
from orders
order by purchase_amount desc

--Display the full data of orders that have purchase amount less than 500

select * from 
orders
where purchase_amount < 500

--Display the full data of orders that have purchase amount between 1000 and 2000.

select *
from orders
where purchase_amount between 1000 and 2000

commit

--Activity 7

--Write an SQL statement to find the total purchase amount of all orders.

select * from orders

select sum(purchase_amount) as "Total Amount"
from orders

--Write an SQL statement to find the average purchase amount of all orders.
select avg(purchase_amount) as "Avegare Amount"
from orders

select min(purchase_amount) as "Avegare Amount"
from orders

select max(purchase_amount) as "Avegare Amount"
from orders

--Write an SQL statement to find the number of salesmen listed in the table.

select count(order_no)
from orders

--Activity 8
--Write an SQL statement to find the highest purchase amount ordered by the each customer with their ID and highest purchase amount.

select customer_id, max(purchase_amount) as "Highest Purchase Amount"
from orders
group by customer_id

--Write an SQL statement to find the highest purchase amount on '2012-08-17' for each salesman with their ID.

select customer_id, max(purchase_amount)
from orders
where order_date = '17-Aug-2012'
group by customer_id;

SELECT salesman_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders 
WHERE order_date=To_DATE('2012/08/17', 'YYYY/MM/DD') GROUP BY salesman_id, order_date;

--Write an SQL statement to find the highest purchase amount with their ID and order date, for only those customers who have a higher purchase amount within the list [2030, 3450, 5760, 6000].
SELECT salesman_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders
group by salesman_id,order_date
having max(purchase_amount) in (2030, 3450, 5760, 6000)


-- Create the customers table
create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);

-- Insert values into it
INSERT ALL
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001)
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001)
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002)
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002)
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006)
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003)
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007)
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005)
SELECT 1 FROM DUAL;

select * from customers
--Activity 9
--Write an SQL statement to know which salesman are working for which customer.

select a.customer_id, a.customer_name, a.salesman_id
from customers a
inner join customers b
on
a.customer_id = b.customer_id

--Write an SQL statement to make a list in ascending order for the customer who holds a grade less than 300 and works either through a salesman.
select * from customers;
select * from salesman;

select a.customer_id, a.customer_name, a.salesman_id
from customers a
inner join customers b
on
a.customer_id = b.customer_id
and a.grade < 300
order by customer_id ;

SELECT a.customer_name, a.city, a.grade, b.name AS "Salesman" FROM customers a 
LEFT OUTER JOIN salesman b ON a.salesman_id=b.salesman_id WHERE a.grade<300 
ORDER BY a.customer_id;

--Write an SQL statement to find the list of customers who appointed a salesman for their jobs who gets a commission from the company is more than 12%.


-- Create the customers table
create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);

-- Insert values into it
INSERT ALL
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001)
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001)
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002)
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002)
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006)
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003)
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007)
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005)
SELECT 1 FROM DUAL;

select * from customers;

select * from salesman;

select * from orders;

--Activity 9
--Write an SQL statement to know which salesman are working for which customer

select a.customer_id, a.customer_name, a.salesman_id
from customers a
inner join customers b
on
a.customer_id = b.customer_id

--Write an SQL statement to make a list in ascending order for the customer who holds a grade less than 300 and works either through a salesman.

select s.grade, b.customer_id
from customers b
join salesman s
on b.salesman_id = s.salesman_id
where
s.grade < 300
order by b.customer_id

--Write an SQL statement to find the list of customers who appointed a salesman for their jobs who gets a commission from the company is more than 12%.
select s.grade, b.customer_id
from customers b
join salesman s
on b.salesman_id = s.salesman_id
where
s.commission > 12

--Write an SQL statement to find the details of a order i.e. order number, order date, amount of order, 
--which customer gives the order and which salesman works for that customer and commission rate he gets for an order

select o.order_no, o.order_date, o.purchase_amount,s.commission
from orders o
join customers c
on o.customer_id = c.customer_id
join salesman s
on s.salesman_id = c.salesman_id

--Activity 10
--Write a query to find all the orders issued against the salesman who may works for customer whose id is 3007.
select o.order_no, o.order_date, o.purchase_amount,s.commission
from orders o
join salesman s
on o.salesman_id = s.salesman_id
join customers c
on o.customer_id= c.customer_id
where c.customer_id = 3007;

SELECT * FROM orders
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);

-- Write a query to find all orders attributed to a salesman in New York.

select  o.order_no, o.order_date, o.purchase_amount,s.commission
from orders o
join salesman s
on o.salesman_id = s.salesman_id
where s.salesman_city = 'New York';

SELECT * FROM orders
WHERE salesman_id IN (SELECT salesman_id FROM salesman WHERE salesman_city='New York');

---- Write a query to count the customers with grades above New York's average.
select grade, count(*)
from customers c
group by grade
having grade > (select avg(grade) from customers where city = 'New York')

-- Write a query to extract the data from the orders table for those salesman who earned the maximum commission
SELECT order_no, purchase_amount, order_date, salesman_id FROM orders
WHERE salesman_id IN( SELECT salesman_id FROM salesman
WHERE commission=( SELECT MAX(commission) FROM salesman));

-- Write a query that produces the name and number of each salesman and each customer with more than one current order. Put the results in alphabetical order
SELECT customer_id, customer_name FROM customers a
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id)
UNION
SELECT salesman_id, name FROM salesman a
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id)
ORDER BY customer_name;

-- Write a query to make a report of which salesman produce the largest and smallest orders on each date.
SELECT a.salesman_id, order_no, 'highest on', order_date FROM salesman a, orders b
WHERE a.salesman_id=b.salesman_id
AND b.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = b.order_date)
UNION
SELECT a.salesman_id, order_no, 'lowest on', order_date FROM salesman a, orders b
WHERE a.salesman_id=b.salesman_id