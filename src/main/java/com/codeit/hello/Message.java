package com.codeit.hello;

public class Message {
    // 필드 (private으로 보호)
    private String content = "안녕!";
    private String author;

    // 기본 생성자
    public Message() {
        System.out.println("Message 객체 생성!");
    }

    // 파라미터가 있는 생성자
    public Message(String content) {
        this.content = content;
        System.out.println("Message 객체 생성!");
    }

    // 일반 메소드
    public int getContentLength() {
        return this.content.length();
    }

    // Setter 메소드
    public void setContent(String content) {
        if (content != null && content.contains("바보")) {
            return;
        }
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter 메소드
    public String getContent() {
        return this.content;
    }

    public String getAuthor() {
        return this.author;
    }
}
