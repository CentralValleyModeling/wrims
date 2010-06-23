[Setup]

AppName              =WRIMS v1.3.3 beta (XA13)
DefaultGroupName     =WRIMS v1.3.3 beta (XA13)
AppVerName           =WRIMS v1.3.3 beta (XA13)
UninstallDisplayName =WRIMS v1.3.3 beta (XA13)
AppId                =WRIMS v1.3.3 beta (XA13)

OutputBaseFilename   =WRIMS_v1.3.3_beta_(XA13)

DefaultDirName    =c:\WRIMS_v1.3.3_beta_XA13

AppPublisher=CA DWR
AppPublisherURL=http://baydeltaoffice.water.ca.gov/modeling/hydrology/CalSim/index.cfm
AppSupportURL=http://baydeltaoffice.water.ca.gov/modeling/hydrology/CalSim/index.cfm
AppUpdatesURL=http://baydeltaoffice.water.ca.gov/modeling/hydrology/CalSim/index.cfm
AllowNoIcons=yes
;Compression=lzma/ultra
Compression=lzma/fast
CompressionThreads=auto
SolidCompression=no
ChangesEnvironment=yes
UninstallFilesDir={app}\bin\uninstall
UninstallLogMode=new
;UninstallLogMode=append
InfoBeforeFile=".\infoFile.rtf"
OutputDir="."
AlwaysRestart = no
PrivilegesRequired = admin
LicenseFile="..\license\COPYRIGHT.txt"


[Languages]

Name: "english"; MessagesFile: "compiler:Default.isl"


[Tasks]

Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"
Name: "quicklaunchicon"; Description: "{cm:CreateQuickLaunchIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked


[Dirs]

Name: "{app}\bin"
Name: "{app}\jre"
Name: "{app}\lib"
Name: "{app}\svg"


[Components]

Name: "main"; Description: "Main Files"; Types: full compact custom;


[Files]

Source: "..\jre\*";        Excludes: ".svn";            DestDir: "{app}\jre\";       Flags: ignoreversion recursesubdirs createallsubdirs ; Components: main
Source: "..\bin\*";        Excludes: ".svn, xa*.dll";   DestDir: "{app}\bin\";       Flags: ignoreversion recursesubdirs createallsubdirs ; Components: main
Source: "..\lib\*";        Excludes: ".svn";            DestDir: "{app}\lib\";       Flags: ignoreversion recursesubdirs createallsubdirs ; Components: main
Source: "..\svg\*";        Excludes: ".svn";            DestDir: "{app}\svg\";       Flags: ignoreversion recursesubdirs createallsubdirs ; Components: main
Source: "..\license\*";    Excludes: ".svn";            Destdir: "{app}\";           Flags: ignoreversion recursesubdirs createallsubdirs ; Components: main

[Icons]

Name:       "{group}\WRIMS v1.3.3 beta (XA13)";     Filename: "{app}\"
Name:       "{group}\Run WRIMS v1.3.3 beta (XA13)"; Filename: "{app}\bin\WRIMS.bat"
Name:         "{app}\WRIMS v1.3.3 beta (XA13)";     Filename: "{app}\bin\WRIMS.bat"
Name: "{userdesktop}\WRIMS v1.3.3 beta (XA13)";     Filename: "{app}\bin\WRIMS.bat";         Tasks: desktopicon
Name:       "{group}\Uninstall";                    Filename: "{uninstallexe}"

[UninstallDelete]

Type: files; Name: "{app}\bin\WRIMS.bat"

[code]

procedure CurStepChanged(CurStep: TSetupStep);
var
    location: String;
    template: String;
    batchString: String;
begin

  location:=ExpandConstant('{app}\bin\WRIMS.bat');
  ///template:= '@echo off'+#13#10+'rem ###############'+#13#10
  
  template :=           '@echo off'
             + #13#10 + 'set path={app}\bin;%path%'
             + #13#10
             + #13#10 + 'start {app}\jre\bin\java -Xmx512m -Dcalsim.home={app} -cp '
             +          '"'
             +          '{app}\lib\calsim.jar;'
             +          '{app}\lib\vista.jar;'
             +          '{app}\lib\Acme.jar;'
             +          '{app}\lib\COM.jar;'
             +          '{app}\lib\jpython.jar;'
             +          '{app}\lib\jhall.jar;'
             +          '{app}\lib\collections.jar;'
             +          '{app}\lib\calsim-help.jar;'
             +          '{app}\lib\data.jar;'
             +          '{app}\lib\hec.jar;'
             +          '{app}\lib\heclib.jar;'
             +          '{app}\lib\JGo.jar;'
             +          '{app}\lib\JGoSVG.jar;'
             +          '{app}\lib\msgsystem.jar;'
             +          '{app}\lib\rma.jar;'
             +          '{app}\lib\WrimsSchematic.jar;'
             +          '{app}\lib\xml.jar"'
             +          ' calsim.gui.CalsimGui %1';

  batchString := ExpandConstant(template);
  
  case CurStep of
    ssPostInstall:
        SaveStringToFile(location, batchString, False);
  end;
end;
