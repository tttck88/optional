package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Optional<String> optional = Optional.empty();

        System.out.println(optional); // Optional.empty
        System.out.println(optional.isPresent()); // false

        // Optional의 value는 값이 있을 수도 있고 null 일 수도 있다.
        optional = Optional.ofNullable(getName());
        String name = optional.orElse("anonymous"); // 값이 없다면 "anonymous"를 리턴
        
        // Java8 이전
        List<String> names = getNames();
        List<String> tempNames = list != null ? list : new ArrayList<>();

        List<String> nameList = Optional.ofNullable(getList()).orElseGet(() -> new ArrayList<>());
    }


/////////////////////////////////////////////////////////////////////////////////
    public String findPostcode() {
        UserVO userVO = getUser();
        if(userVO != null) {
            Address address = userVO.getAddress();
            if(address != null ) {
                String postCode = address.getPostCode();
                if(postCode != null) {
                    return postCode;
                }
            }
        }
        return "우편번호 없음";
    }

    public UserVO getUser() {
        return new UserVO(new Address("인천"), "주소");
    }

    public String findPostCode() {
        // 위 코드를 Optional로 펼쳐놓으면 아래와 같다.
        Optional<UserVO> userVO = Optional.ofNullable(getUser());
        Optional<Address> address = userVO.map(UserVO::getAddress);
        Optional<String> postCode = address.map(Address::getPostCode);
        String result = postCode.orElse("우편번호 없음");

        String result = userVO.map(UserVO::getAddress)
            .map(Address::getPostCode)
            .orElse("우편번호없음");
    }

///////////////////////////////////////////////////////////////////
    String name = getName();
    String result = "";

    try {
        result = name.toUpperCase();
    } catch (NullPointerException e) {
        throw new CustomUpperCaseException();
    }

    Optional<String> nameOpt = Optional.ofNullable(getName());
    String result = nameOpt.orElseThrow(CustomUpperCaseExcpetion::new)
        .toUpperCase();
}













