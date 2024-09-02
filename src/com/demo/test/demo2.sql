CREATE DEFINER=`Soumyajit`@`%` PROCEDURE `demo2`(IN rollcheck integer)
BEGIN
select Student.name from CallableTesting.Student where Student.roll > rollcheck;
END