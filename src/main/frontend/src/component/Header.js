import React from 'react';

function Header() {
    return (
        <header className="d-flex justify-content-between">
            <div className="d-flex align-items-center">
                <div className="logo"><img alt="로고" src="/img/logo.png" className="align-middle" width="64" /></div>
                <div><h1><a href="http://localhost:8080/user" className="logo-text">SMARTBUTLER</a></h1></div>
            </div>
            <div className="d-flex align-items-center" style={{ gap: "50px", marginRight: "200px" }}>
                <div><a href="http://localhost:8080/user/mypage">마이페이지</a></div>
                <div><a href="http://localhost:3000/user/buildings/info">건물 정보 보기</a></div>
                <div><a href="http://localhost:8080/user/estimate">견적 신청</a></div>
                <div><a href="http://localhost:8080/user/claims">민원 신청</a></div>
            </div>
        </header>
    );
}

export default Header;