# Portal

This project is about creating an online site for university works,which three type of people can use it Admin, Professors,Students.

Each user has it own responsiblities and all of them will be stored in files:

## Admin

1. There is only <b>ONE</b> admin(username:admin, password:12345678).
2. He/She password must be at least 8 characters.
3. Can change her/his username or password.
4. Can scheduale  food meal of students for following week.
5. Has list of students and professors.
6. Make courses (Course name,Professor name,Course units).
7. Adding students and professors.
8. Has list of classes(which professors make).

------

## Professors

1. Can change her/his username and password.

2. He/She password must be at least 8 characters

3. Should make class for students which must contains:

   - [ ] Day(from Saturday till Wednesday);

   - [ ] Time range( 8-10 |||| 10-12  |||| 14-16);

4. Must have a list of all students which have courses with him/her.

5. Give grade to students,the grade influences in students average.

6. Close a class.

   ------

   ## Students

1. Can change her/his username and password.

2. He/She password must be at least 8 characters.

3. Increase her/his bank account money(by entering his/her card number and password and the amount of money).

4. Can see his/her weekly meal plan and order food(must decrease the amount of money for bank account).

5. Take courses with some conditions:

   Class must have capacity(if not an error must be shown).

   If he/she has 20 units and her/his average is **lower** than 17 she/he cant take any other classes.(if profressors haven't given grade the average will be considered lower than 17  ).

   If he/she has 20 units and her/his average is **higher** than 17 she/he can take other classes up to 24 units(if she/he take more than 24 units an error will occur).

   If a professor close a class must be deleted from student list of classes and student can take another class on that time.

6. Can see list of selected classes.

   ------

   #### Help

you can run this program in terminal using these instructions:

first open terminal in Portal folder then:

```java
java -cp out/production/Portal Main
```

if you have compiler error open IntelliJ (Intellij IDEA->preferences->Build,Execution,Deployment->compiler->Java compiler->Project bytecode version->**15**).

------

##### Author:

Rojina kashefi
