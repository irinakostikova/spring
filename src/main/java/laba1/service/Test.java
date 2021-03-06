package laba1.service;

import laba1.csv.ICSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Service
public class Test {

    @Autowired
    private ICSVReader reader;
    private int count;



    public void startTest() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Для ответа напишите номер правильного варианта!\n");

        List<Question> questions = reader.getQuestions();
        for (int i = 0; i< questions.size(); i++) {
            //System.out.println(question.getQuestion());
            // System.out.println(question.getVar());
            System.out.println("Вопрос:"+ questions.get(i).getQuestion() + "\nВарианты:" + questions.get(i).getVar());
            String phrase1=sc.nextLine();
            // String phrase=question.getAnswer();
            // if(phrase1.regionMatches(true,0,phrase,0,1)){
            if (phrase1.equalsIgnoreCase(questions.get(i).getAnswer())) {
                count++;
            }
        }
        System.out.println("Ваш результат "+count+" из 5");
    }
}
