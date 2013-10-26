SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

USE vk;

SET AUTOCOMMIT=0;
INSERT INTO question (content, answer_A, answer_B, answer_C, answer_D, answer_E, right_answer)
    VALUES('Каким будет результат компиляции и выполнения данного кода?
        01. class A { 
        02.     public void process() { System.out.print("A "); } 
        03. } 
        04. public class B extends A { 
        05.     public void process() throws RuntimeException { 
        06.         super.process(); 
        07.         if (true) throw new RuntimeException(); 
        08.         System.out.print("B"); 
        09.     } 
        10.  
        11.     public static void main(String[] args) { 
        12.         try { ((A)new B()).process(); } 
        13.         catch (Exception e) { System.out.print("Exception "); } 
        14.     } 
        15. }' , 'Ошибка компиляции в строке 12', 'A Exception', 'Ошибка компиляции в строке 5',
        'A B Exception', 'Exception', 'B'
    );

INSERT INTO user (user_id, question_id, answer, cor_answer, matches, answer_number, right_answer_number)
    VALUES(1, 1, 'C', 'B', 'n', 1, 1
    );

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
