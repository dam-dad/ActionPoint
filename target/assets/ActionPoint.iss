#define MyAppName "ActionPoint"
#define MyAppVersion "0.0.1-SNAPSHOT"
#define MyAppPublisher "ACME"
#define MyAppURL ""
#define MyAppExeName "ActionPoint.exe"
#define MyAppFolder "ActionPoint"
#define MyAppLicense "C:\Users\Gapaz\Desktop\ActionPoint-main\LICENSE"
#define MyAppIcon "C:\Users\Gapaz\Desktop\ActionPoint-main\target\assets\ActionPoint.ico"

[Setup]
AppId={{{#MyAppName}}}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
AppVerName={#MyAppName} {#MyAppVersion}
AppPublisher={#MyAppPublisher}
AppPublisherURL={#MyAppURL}
AppSupportURL={#MyAppURL}
AppUpdatesURL={#MyAppURL}
DefaultDirName={autopf}\{#MyAppFolder}
DisableDirPage=yes
DisableProgramGroupPage=yes
DisableFinishedPage=yes
DisableWelcomePage=yes
PrivilegesRequired=admin
PrivilegesRequiredOverridesAllowed=commandline
LicenseFile={#MyAppLicense}
SetupIconFile={#MyAppIcon}
UninstallDisplayIcon={app}\{#MyAppExeName}
Compression=lzma
SolidCompression=yes
ArchitecturesInstallIn64BitMode=x64

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"
Name: "spanish"; MessagesFile: "compiler:Languages\Spanish.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Registry]

[Files]
Source: "C:\Users\Gapaz\Desktop\ActionPoint-main\target\ActionPoint\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs

[Icons]
Name: "{autoprograms}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; IconFilename: "{app}\ActionPoint.ico"
Name: "{autodesktop}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; IconFilename: "{app}\ActionPoint.ico"; Tasks: desktopicon

[Run]

[Code]

function GetInstallLocation(): String;
var
    unInstPath: String;
    installLocation: String;
begin
    unInstPath := ExpandConstant('Software\Microsoft\Windows\CurrentVersion\Uninstall\{#emit SetupSetting("AppId")}_is1');
    installLocation := '';
    if not RegQueryStringValue(HKLM, unInstPath, 'InstallLocation', installLocation) then
        RegQueryStringValue(HKCU, unInstPath, 'InstallLocation', installLocation);
    Result := RemoveQuotes(installLocation);
end;


procedure CurStepChanged(CurStep: TSetupStep);
begin
    if CurStep = ssInstall then
    begin
    end;
end;
