[Setup] 
AppName              =CalSimPA 
DefaultGroupName     =CalSimPA
AppVerName           =CalSimPA 
UninstallDisplayName =CalSimPA 
AppId                =CalSimPA
OutputBaseFilename   =CalSimPA_Install
DefaultDirName       =c:\CalSimPA   


AppPublisher=CA_DWR
AllowNoIcons=no
;Compression=lzma2/normal
;Compression=lzma2/ultra
Compression=lzma2/fast
CompressionThreads=auto
SolidCompression=no
UninstallFilesDir={app}\bin
UninstallLogMode=new
;UninstallLogMode=append
InfoBeforeFile=".\infoFile.rtf"
OutputDir="."
AlwaysRestart = no
PrivilegesRequired = admin 


[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"


[Dirs]
Name: "{app}\bin"
Name: "{app}\lib"
Name: "{app}\scripts"
Name: "{app}\studies"
Name: "{app}\doc"


[Files]
Source: "..\BST_2005A01A_Existing_CALSIM_040110_PA.py"; Flags: dontcopy
Source: "..\WRIMSv1_test.py"; Flags: dontcopy
Source: "..\WRIMSv2_test.py"; Flags: dontcopy

Source: "..\lib\hecdss\*";     Excludes: ".svn";            DestDir: "{app}\lib\hecdss";     Flags: ignoreversion recursesubdirs createallsubdirs ; 
Source: "..\lib\jython252\*";  Excludes: ".svn, *.pkc";     DestDir: "{app}\lib\jython252";  Flags: ignoreversion recursesubdirs createallsubdirs ; 
Source: "..\lib\wrims13\*";    Excludes: ".svn, xa*.dll";   DestDir: "{app}\lib\wrims13";    Flags: ignoreversion recursesubdirs createallsubdirs ; 
Source: "..\lib\wrims2\*";     Excludes: ".svn, xa*.dll";   DestDir: "{app}\lib\wrims2";     Flags: ignoreversion recursesubdirs createallsubdirs ; 
Source: "..\lib\jre6\*";       Excludes: ".svn, ";          DestDir: "{app}\lib\jre6";       Flags: ignoreversion recursesubdirs createallsubdirs ; 

Source: "..\scripts\*";         Excludes: ".svn, *.bak, *.class, *.pyc";     DestDir: "{app}\scripts\";      Flags: ignoreversion recursesubdirs createallsubdirs ; 
Source: "..\studies\*";         Excludes: ".svn, *.log, *.out, *.trc, CALSIM_040110_CAM";   Destdir: "{app}\studies";       Flags: ignoreversion recursesubdirs createallsubdirs ; 
Source: "..\bin\*.cmd";         Excludes: ".svn";                            Destdir: "{app}\bin\";          Flags: ignoreversion recursesubdirs createallsubdirs ; 
Source: "..\*.template.*";      Excludes: ".svn, distro";                    Destdir: "{app}\";              Flags: ignoreversion recursesubdirs createallsubdirs ; 

Source: "..\doc\*.pdf";         Excludes: ".svn";           Destdir: "{app}\doc";              Flags: ignoreversion recursesubdirs createallsubdirs ; 

[Icons]
Name: "{app}\CalSimPA";     Filename: "{app}\bin\CalSimPA.cmd"; WorkingDir: "{app}\bin" ;
Name: "{userdesktop}\CalSimPA"; Filename: "{app}" ; 


[UninstallDelete]
Type: files; Name: "*.sty_PA" ;
Type: files; Name: "*.table_PA" ;
Type: files; Name: "*.log" ;
Type: files; Name: "*.dsc" ;
Type: files; Name: "*.dsd" ;
Type: dirifempty; Name: "studies\*" ;
Type: dirifempty; Name: "studies" ;
Type: files; Name: "{app}\BST_2005A01A_Existing_CALSIM_040110_PA.py" ;
Type: filesandordirs; Name: "{app}\lib\*" ;
Type: files; Name: "{app}\scripts\*.class" ;
Type: dirifempty; Name: "{app}" ;


[code]
procedure CurStepChanged(CurStep: TSetupStep);
var
    location: String;
    template: String;
    pyString: String;
begin

  ExtractTemporaryFile('BST_2005A01A_Existing_CALSIM_040110_PA.py');
  if LoadStringFromFile(ExpandConstant('{tmp}\BST_2005A01A_Existing_CALSIM_040110_PA.py'), template) then
    begin

      pyString := ExpandConstant(template);

      location := ExpandConstant('{app}\BST_2005A01A_Existing_CALSIM_040110_PA.py');
  
    case CurStep of

      ssPostInstall:
      SaveStringToFile(location, pyString, False);
    
    end;
  end;
end;
