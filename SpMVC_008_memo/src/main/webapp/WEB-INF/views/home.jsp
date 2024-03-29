<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<script>
	const rootPath = '${rootPath}'
</script>
<style>
    div.images {
        display: flex;
        width: 600px;
        height: 400px;
        transition: 1s;
    }
    div.images img {
        width: 600px;
    }
    div.image_window {
        width: 600px;
        height: 400px;
        overflow: hidden;
        position: relative;
    }
    div.btn_box {
        width: 600px;
        display: flex;
        position: absolute;
        left: 0;
        bottom: 0;
        padding: 30px 20px;
        z-index: 100;
        opacity : 0;
        transition: opacity 0.6s;
        }
    div.btn_box:hover {
        opacity: 1;
    }
    div.badge {
        flex: 1;
        display: flex;
        justify-content: center;
        align-items: center;

    }

    span.badge {
        background-color: #000;
        color: #fff;
        display: inline-block;
        border-radius: 50%;
        border: 2px solid white;
        width: 15px;
        height: 15px;
        margin: 0 5px;
    }
    span.badge:hover {
        cursor: pointer;
        background-color: white;
    }
    button.btn {
        width: 100px;
        height: 30px;
        border: none;
        color: white;
        background-color: transparent;
    }

    button.btn.prev {
        margin-right: auto;
    }
    button.btn.next {
        margin-left: auto;
    }
</style>
</head>
<%@ include file="include/header.jsp"%>
<body>
    <div class="image_window">
        <div class="images">
            <img src="/images/australian.jpg"/>
            <img src="/images/dessert.jpg"/> 
            <img src="/images/russian.jpg"/> 
            <img src="/images/women.jpg"/> 
            <img src="/images/yoga.jpg"/> 
        </div>
        <div class="btn_box">
            <button class="btn prev">&#10094;</button>
            <div class="badge"></div>
        </div>
            <button class="btn next">&#10095;</button>
    </div>
</body>
<script>
    document.addEventListener("DOMContentLoaded", ()=>{
        const IMAGE_WIDTH = 600;
        const preBtn = document.querySelector("button.prev");
        const nextBtn = document.querySelector("button.next");
        const images = document.querySelector("div.images");
        // 화면 slide 되는 이미지 개수를 담는 변수
        const imgCount = document.querySelectorAll("div.images img").length;

        let position = 0;
        let curPosition = 0;
        if(preBtn) {
            preBtn.addEventListener("click",()=>{
                if(curPosition > 0) {
                    position += IMAGE_WIDTH
                    images.style.transform = `translateX(${position}px)`;
                    curPosition --;
                }
            });
        }
        if(nextBtn) {
            nextBtn.addEventListener("click", ()=> {
                if(curPosition < imgCount -1) {
                    position -= IMAGE_WIDTH;
                    images.style.transform = `translateX(${pos}px)`;
                    curPosition++;
                }
            });
        } // end if nextBtn

        const badge_click_cb = (e,pos) => {
            console.log("badge index : ", pos);
            // 만약 3번 badge를 클릭했다 라고 하면
            // -2 * IMAGE_WIDTH 가 계산되고
            // -1200
            // 현재 위치가 3번인데 0을 클릭했다
            // transX 는 0 이 된다.
            const transX = -pos * IMAGE_WIDTH
            images.style.transform = `translateX(${transX}px)`

        };
        // span.badge 를 감싸고 있을 부모 tag(container)
        const divBadge = document.querySelector("div.badge")
        for(let index = 0; index < imgCount ; index++) {

            // tag를 JS 코드에서 동적으로 생성하기
            const span = document.createElement("span")
            // 생성된 span tag에 badge 클래스를 추가하고
            span.classList.add("badge");
            span.addEventListener("click", (e)=> {
                badge_click_cb(e,index);
            });

            // 생성된 span tag 를 div.badge tag 에 child 로 추가하라
            divBadge.appendChild(span);

        }

        let count = 0;
        const interval_cb = (e) => {
            badge_click_cb(e, ++count % imgCount);
            if (count > imgCount * 100) count = 0;
        };
</script>
</html>

