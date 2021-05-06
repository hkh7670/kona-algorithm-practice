class 서승환_72410 {
    public String solution(String new_id) {
        
        String answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^-_.a-z0-9]", "");
        answer = answer.replaceAll("[.]+", ".");
        answer = answer.replaceAll("^[.]|[.]$", "");
        if(answer.equals("")) answer = "a";
        if(answer.length() > 15) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }
        if(answer.length() < 3){
            while(answer.length() < 3){
                answer += answer.charAt(answer.length() - 1);
            }
        }
        return answer;
    }
}