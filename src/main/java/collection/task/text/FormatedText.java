package collection.task.text;

import collection.task.text.word.Word;

import java.util.Set;
import java.util.TreeSet;

public class FormatedText {

    private Set<Word> words = new TreeSet<>();

    public FormatedText() {
    }

    public FormatedText(Set<Word> words) {
        this.words = words;
    }

    public void addWordInText(String word){
        Word w = new Word(word);
        words.add(w);
    }

    public void addWordInText(String[] str){
        for (String word : str) {
            if (!word.isEmpty()) {
                Word w = new Word(word);
                words.add(w);
            }
        }
    }

    @Override
    public String toString() {
        return words.toString();
    }

    private Word calculateMaxCountInTextWord(){
        int max = -1;
        Word w = null;
        for (Word word : words){
            if (max<word.getCountInText()){
                max = word.getCountInText();
                w = word;
            }
        }
        return w;
    }

    public Word getMaxCountInTextWord(){
        return calculateMaxCountInTextWord();
    }

    public int getCountWordInText(){
        int countWord = 0;
        for (Word word: words){
            countWord = countWord + word.getCountInText();
        }
        return countWord;
    }



}
