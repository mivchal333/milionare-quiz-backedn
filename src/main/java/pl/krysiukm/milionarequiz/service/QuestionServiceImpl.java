package pl.krysiukm.milionarequiz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.krysiukm.milionarequiz.bean.QuestionBean;
import pl.krysiukm.milionarequiz.model.Difficulty;
import pl.krysiukm.milionarequiz.model.Question;
import pl.krysiukm.milionarequiz.repository.QuestionRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final BeanHelper beanHelper;

    @Override
    public List<Question> getQuestions(Difficulty difficulty) {
        return questionRepository.findAllByDifficulty(difficulty);
    }

    @Override
    public Optional<Question> getQuestion(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public List<Question> getQuestions(Difficulty difficulty, int limit) {
        Page<Question> questionsPage = questionRepository.findAll(PageRequest.of(0, limit));
        return questionsPage.getContent();
    }

    @Override
    public List<Question> saveQuestions(List<Question> questions) {
        return questionRepository.saveAll(questions);
    }

    @Override
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public void initializeQuestions() {
        QuestionBean question1 = QuestionBean.builder()
                .question("What is a correct syntax to output \"Hello World\" in Java?")
                .correctAnswer("System.out.println(\"Hello World\");")
                .incorrectAnswers(Arrays.asList("print (\"Hello World\");",
                        "Console.WriteLine(\"Hello World\");",
                        "println(\"Hello World\");"))
                .build();
        QuestionBean question2 = QuestionBean.builder()
                .question("How do you insert COMMENTS in Java code?")
                .correctAnswer("// This is comment")
                .incorrectAnswers(Arrays.asList("/- This is comment",
                        "** This is comment",
                        "# This is comment"))
                .build();
        QuestionBean question3 = QuestionBean.builder()
                .question("Java is short for \"JavaScript\".")
                .correctAnswer("False")
                .incorrectAnswers(Arrays.asList("True"))
                .build();
        QuestionBean question4 = QuestionBean.builder()
                .question("Is String a primitive data type?")
                .correctAnswer("No")
                .incorrectAnswers(Arrays.asList("Yes"))
                .build();
        QuestionBean question5 = QuestionBean.builder()
                .question("Which method to use to find length of a string?")
                .correctAnswer("length()")
                .incorrectAnswers(Arrays.asList("long()",
                        "size()",
                        "count()"))
                .build();
        QuestionBean question6 = QuestionBean.builder()
                .question("Which is correct method to convert String into uppercase")
                .correctAnswer("toUpperCase()")
                .incorrectAnswers(Arrays.asList("toUpper()",
                        "changeUpperCase()",
                        "convertUpperCase()"))
                .build();

        QuestionBean question7 = QuestionBean.builder()
                .question("String x = \"10\"; String y = \"20\"; String z = x + y; System.out.println(z); Guess the output.\n")
                .correctAnswer("1020")
                .incorrectAnswers(Arrays.asList("10 20",
                        "30",
                        "\"10 20\""))
                .build();
        QuestionBean question8 = QuestionBean.builder()
                .question("Choose most appropriate purpose of trim() method in String?")
                .correctAnswer("to remove extra white spaces from start and end of String")
                .incorrectAnswers(Arrays.asList("to get a substring of the string",
                        "to cut String at desired index",
                        "to remove white spaces between words"))
                .build();
        QuestionBean question9 = QuestionBean.builder()
                .question(" What is the most appropriate way to check if two Strings are identical?")
                .correctAnswer("string1.equals(string2)")
                .incorrectAnswers(Arrays.asList("string1.equalsIgnorecase(string2)",
                        "string1.same(string2)",
                        "string1 == string2"))
                .build();
        QuestionBean question10 = QuestionBean.builder()
                .question("Select correct code to create an array of \"double\" datatype of length 5")
                .correctAnswer("double[] arr = new double[5];")
                .incorrectAnswers(Arrays.asList("double[5] arr = new double[];",
                        "double{} arr = new double{5};",
                        "double arr = double[5];"))
                .build();
        QuestionBean question11 = QuestionBean.builder()
                .question("The value of a string variable can be surrounded by single quotes.")
                .correctAnswer("False")
                .incorrectAnswers(Arrays.asList("True"))
                .build();
        QuestionBean question12 = QuestionBean.builder()
                .question("What is the correct way to create an object called myObj of MyClass?")
                .correctAnswer(" MyClass myObj = new MyClass();")
                .incorrectAnswers(Arrays.asList(
                        " new myObj = MyClass();",
                        " class myObj = new MyClass();",
                        " class MyClass = new myObj();"))
                .build();
        List<QuestionBean> questionBeans = Arrays.asList(
                question1, question2, question3, question4, question5, question6, question7, question8, question9, question10, question11
                , question12);
        List<Question> questions = questionBeans.stream().map(beanHelper::getQuestion)
                .collect(Collectors.toList());
        if (questionRepository.count() == 0) {
            questionRepository.saveAll(questions);
        }
    }
}
