# 프로젝트(게임) 제목
팔라독
# 게임 컨셉
2D 횡스크롤 게임으로, 웨이브마다 나오는 적을 물리치고 나아가 상대의 집을 부수는 게임입니다. 플레이어에게는 마나와 식량 스탯이 있고 마나를 사용해서 직접 공격하거나, 식량을 소모하여 전투를 돕는 유닛을 뽑을 수 있습니다. 플레이어의 체력이 소진된 경우 게임이 종료됩니다.

# 개발 범위
게임 내 전투에 필요한 유닛 3종, 적 유닛 3종 공격, 이동 애니메이션 및 공격 구현, 플레이어의 이동, 스테이지 2개 구현 

# 개발 진행도
![image](https://user-images.githubusercontent.com/44054161/236828442-985f9cc4-08f0-401f-836b-16a48cf33f8e.png)

# 커밋 기록
![image](https://user-images.githubusercontent.com/44054161/236828496-d7f13896-86db-47e5-be6f-10b5aa440b5a.png)

# 클래스 구성 정보
![image](https://user-images.githubusercontent.com/44054161/236828563-af1d19b3-14a7-4fa2-963b-49d0071c946c.png)
<br/><br/><br/><br/><br/>
IGameObject - 오브젝트들이 가지고 있는 인터페이스


![image](https://user-images.githubusercontent.com/44054161/236832857-d3de3244-f022-4fc1-ba15-8095dd8b7150.png)<br/>
Unit - move, idle, attack, die등의 여러 상태 및 각 상태에 따른 animation Sprite를 갖고, 타 Unit들과 상호작용하는 클래스
<br/><br/>

![paladogidle](https://user-images.githubusercontent.com/44054161/236831126-d2addfbb-575a-49bc-a6ff-825ea6c2dfdb.png)
Paladog - 플레이어 객체. 버튼을 통한 조작으로 유저가 직접 조종할 수 있는 Unit      
<br/><br/><br/>
Minion - 플레이어와 별개로 소환되어 스스로 움직이고 공격하는 Unit.



![ally3move](https://user-images.githubusercontent.com/44054161/236831154-2007be23-f5fc-4de2-baa2-e98c68f4e205.png)<br/>
Ally - 플레이어를 도와 Enemy들을 공격하는 Minion
<br/><br/><br/>
![image](https://user-images.githubusercontent.com/44054161/236831263-ddf1b3a5-b026-4ebd-901d-f1f270431bbd.png)<br/>
Enemy - 적군을 나타내는 Minion
<br/><br/><br/>

Paladog은 Idle상태이고, 이동 버튼을 누르면 Move상태, 공격 버튼을 누르면 attack상태로 바뀌며 각 상태에 맞는 스프라이트가 출력됨
Ally, Enemy는 기본적으로 Move상태, 각자의 진행방향으로 이동하다가 적 Minion을 만난 경우 attack상태가 되어 상대를 공격하고, 
죽을 경우 die 상태가 됨
<br/><br/><br/><br/><br/>

UI - 이동, 공격등 액션이 없고 화면에 출력만 하거나 UI를 담당하는 클래스



IButtonReact - 버튼이 눌렸을 때의 액션을 모두 따로 정의하기 위한 인터페이스<br/>
![image](https://user-images.githubusercontent.com/44054161/236830686-0652bcc3-d261-4e58-99ca-621555efe48c.png)<br/>
UIButton - 버튼의 기능을 하는 UI. IButtonReact 인터페이스를 갖고 있으며 일반 상태, 눌린 상태를 따로 지정 가능


<br/><br/>
![foodgauge](https://user-images.githubusercontent.com/44054161/236830942-dcd8c1f2-b7a1-4785-be40-7a40118920b8.png)<br/>
<br/>
Gauge - 식량, 마나 게이지를 표시하기 위한 UI
<br/><br/>

![num](https://user-images.githubusercontent.com/44054161/236831394-c61a5823-e687-44c3-b3fa-aa3fedcd0cdb.png)<br/>

Number - 숫자를 스프라이트 이미지로 표시하기 위한 UI
<br/><br/>
![bg1](https://user-images.githubusercontent.com/44054161/236831431-5e019b1b-4811-47a9-b267-cb37643f8ee4.png)<br/>

MovableUI - PlayScene에서 플레이어의 위치에 따라 그려지는 위치도 같이 변하는 UI (인게임 배경 등)
<br/><br/>    
![atk1](https://user-images.githubusercontent.com/44054161/236830875-f40a9d00-a090-4225-9135-fc2816b784cb.png)<br/>
Attack - 플레이어가 발사한 공격에 대한 클래스
