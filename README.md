A database system in which users schedule and manage marine leisure sports programs.

# Requirements
1. User는 User_id, User_name, User_phone, Reservation_num에 대한 정보를 포함한다.
2. User는 본인의 이름, 폰 번호를 인증하여 회원가입한다.
3. User는 id와 pw로 로그인을 한다.
4. User는 Program_name을 찾아 예약할 수 있다.
5. 여러 명의 User는 여러 개의 체험 Program을 예약할 수 있다.
6. Program은 Program_name, Day, Address, Time, Price, Information에 대한 정보를 포함한다.
7. Program에서 체험할 수 있는 Leisure sport의 event(종목)를 볼 수 있다.
8. Program은 여러 개의 Leisure sport를 포함하고 있다.
9. Leisure sport는 Event, Limit_number에 대한 정보를 포함한다.
10. Facility는 Facility_name, Address, Facility_phone에 대한 정보를 포함한다.
11. Facility는 Facility_name으로 검색할 수 있다.
12. Facility는 Program_name으로 찾아 관리할 수 있다.
13. 여러 개의 Facility에서 여러 개의 Program을 관리한다.

# ER diagram
<div>
  <img src="https://user-images.githubusercontent.com/31759437/69545755-bce81b00-0fd5-11ea-9d1a-59814543cdad.png">
</div>

# Relation schema
<div>
  <img src="https://user-images.githubusercontent.com/31759437/69545870-fcaf0280-0fd5-11ea-9f35-446ff1e2c648.png">
</div>
