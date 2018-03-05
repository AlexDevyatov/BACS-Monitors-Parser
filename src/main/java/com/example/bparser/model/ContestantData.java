package com.example.bparser.model;

public class ContestantData implements Comparable<ContestantData>{

    private String nickname;
    private Integer countOfProblems;

    public ContestantData(String nickname, Integer countOfProblems) {
        this.nickname = nickname;
        this.countOfProblems = countOfProblems;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getCountOfProblems() {
        return countOfProblems;
    }

    public void setCountOfProblems(Integer countOfProblems) {
        this.countOfProblems = countOfProblems;
    }

    @Override
    public int compareTo(ContestantData contestantData) {
        return countOfProblems.compareTo(contestantData.getCountOfProblems());
    }
}
