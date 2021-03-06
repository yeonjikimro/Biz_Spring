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
        // ?????? slide ?????? ????????? ????????? ?????? ??????
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
            // ?????? 3??? badge??? ???????????? ?????? ??????
            // -2 * IMAGE_WIDTH ??? ????????????
            // -1200
            // ?????? ????????? 3????????? 0??? ????????????
            // transX ??? 0 ??? ??????.
            const transX = -pos * IMAGE_WIDTH
            images.style.transform = `translateX(${transX}px)`

        };
        // span.badge ??? ????????? ?????? ?????? tag(container)
        const divBadge = document.querySelector("div.badge")
        for(let index = 0; index < imgCount ; index++) {

            // tag??? JS ???????????? ???????????? ????????????
            const span = document.createElement("span")
            // ????????? span tag??? badge ???????????? ????????????
            span.classList.add("badge");
            span.addEventListener("click", (e)=> {
                badge_click_cb(e,index);
            });

            // ????????? span tag ??? div.badge tag ??? child ??? ????????????
            divBadge.appendChild(span);

        }

        let count = 0;
        const interval_cb = (e) => {
            badge_click_cb(e, ++count % imgCount);
            if (count > imgCount * 100) count = 0;
        };
</script>
</html>

