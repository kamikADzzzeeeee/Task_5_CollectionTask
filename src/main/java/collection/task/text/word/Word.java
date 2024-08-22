package collection.task.text.word;

import java.util.Objects;

public class Word implements Comparable<Word> {

    private String word;
    private int countLetter = 0;
    private int countInText = 1;

    public Word(String word) {
        this.word = word;
        countLetter = word.length();
        //countInText = 1;
    }

    public int getCountLetter() {
        return countLetter;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCountInText() {
        return countInText;
    }


    @Override
    public int compareTo(Word o) {
        int result = -2;
        if (this.equals(o)&&(this!=o)) {
            o.countInText++;
            result = 0;
        } else {
            int firstO1 = (int) this.getWord().charAt(0) - (int) 'a';
            int firstO2 = (int) o.getWord().charAt(0) - (int) 'a';
            if (firstO1 < firstO2) {
                result = -1;
            } else if (firstO1 > firstO2) {
                result = 1;
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return this.word.equals(word1.getWord());

    }

    @Override
    public int hashCode() {
        return Objects.hash(word, countLetter, countInText);
    }

    @Override
    public String toString() {
        return "\n" + word + "(букв - " + countLetter + ", повторений - " + countInText + ")";
    }
}
