Sleep(1000)
ControlFocus("��","","Edit1")

Sleep(1000)

ControlSetText("��", "", "Edit1", "D:\AutoTestAttachment\�ϻ���\roomPic") ;���ļ�Ŀ¼
Sleep(500)

Send("{ENTER}") ;�ûس�

Sleep(1000)

ControlSetText("��", "", "Edit1", '"a.png" "b.png" "c.png" "public.png" "restroom.png" "total.png"') ;�������ļ���

Sleep(500)

ControlClick("��", "","Button1");
