adle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:19:15.657+0300 [DEBUG] [org.gradle.internal.remote.internal.inet.TcpIncomingConnector] Accepted connection from /127.0.0.1:61091 to /127.0.0.1:54011.
2024-08-19T17:19:15.661+0300 [DEBUG] [org.gradle.launcher.daemon.server.SynchronizedDispatchConnection] thread 398: received class org.gradle.launcher.daemon.protocol.Build
2024-08-19T17:19:15.661+0300 [DEBUG] [org.gradle.launcher.daemon.server.DefaultDaemonConnection] thread 398: Received non-IO message from client: Build{id=6b90ee28-74df-4015-9a06-c9e0ed9e96f8, currentDir=D:\Calculator}
2024-08-19T17:19:15.661+0300 [INFO] [org.gradle.launcher.daemon.server.DefaultIncomingConnectionHandler] Received command: Build{id=6b90ee28-74df-4015-9a06-c9e0ed9e96f8, currentDir=D:\Calculator}.
2024-08-19T17:19:15.661+0300 [DEBUG] [org.gradle.launcher.daemon.server.DefaultIncomingConnectionHandler] Starting executing command: Build{id=6b90ee28-74df-4015-9a06-c9e0ed9e96f8, currentDir=D:\Calculator} with connection: socket connection from /127.0.0.1:54011 to /127.0.0.1:61091.
2024-08-19T17:19:15.662+0300 [DEBUG] [org.gradle.launcher.daemon.server.DaemonStateCoordinator] Command execution: started DaemonCommandExecution[command = Build{id=6b90ee28-74df-4015-9a06-c9e0ed9e96f8, currentDir=D:\Calculator}, connection = DefaultDaemonConnection: socket connection from /127.0.0.1:54011 to /127.0.0.1:61091] after 11.0 minutes of idle
2024-08-19T17:19:15.662+0300 [INFO] [org.gradle.launcher.daemon.server.DaemonRegistryUpdater] Marking the daemon as busy, address: [7e94bee2-4324-41c4-b834-a5c93b483536 port:54011, addresses:[localhost/127.0.0.1]]
2024-08-19T17:19:15.662+0300 [DEBUG] [org.gradle.launcher.daemon.registry.PersistentDaemonRegistry] Marking busy by address: [7e94bee2-4324-41c4-b834-a5c93b483536 port:54011, addresses:[localhost/127.0.0.1]]
2024-08-19T17:19:15.662+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire exclusive lock on daemon addresses registry.
2024-08-19T17:19:15.663+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:19:15.664+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:19:15.664+0300 [DEBUG] [org.gradle.launcher.daemon.server.DaemonStateCoordinator] resetting idle timer
2024-08-19T17:19:15.664+0300 [DEBUG] [org.gradle.launcher.daemon.server.DaemonStateCoordinator] daemon is running. Sleeping until state changes.
2024-08-19T17:19:15.664+0300 [INFO] [org.gradle.launcher.daemon.server.exec.StartBuildOrRespondWithBusy] Daemon is about to start building Build{id=6b90ee28-74df-4015-9a06-c9e0ed9e96f8, currentDir=D:\Calculator}. Dispatching build started information...
2024-08-19T17:19:15.664+0300 [DEBUG] [org.gradle.launcher.daemon.server.SynchronizedDispatchConnection] thread 400: dispatching org.gradle.launcher.daemon.protocol.BuildStarted@43bc92bb
2024-08-19T17:19:15.665+0300 [DEBUG] [org.gradle.launcher.daemon.server.exec.EstablishBuildEnvironment] Configuring env variables: [USERDOMAIN_ROAMINGPROFILE, PROCESSOR_LEVEL, SESSIONNAME, ALLUSERSPROFILE, PROCESSOR_ARCHITECTURE, EGPL_GeoLibrarian_Drive, PSModulePath, SystemDrive, MOZ_PLUGIN_PATH, ACSvcPort, USERNAME, ProgramFiles(x86), ACSetupSvcPort, FPS_BROWSER_USER_PROFILE_STRING, PATHEXT, DriverData, ProgramData, ProgramW6432, HOMEPATH, PROCESSOR_IDENTIFIER, ProgramFiles, PUBLIC, windir, =::, LOCALAPPDATA, USERDOMAIN, FPS_BROWSER_APP_PROFILE_STRING, LOGONSERVER, RlsSvcPort, OneDrive, APPDATA, VBOX_HWVIRTEX_IGNORE_SVM_IN_USE, CommonProgramFiles, Path, OS, COMPUTERNAME, PROCESSOR_REVISION, CommonProgramW6432, ComSpec, TEMP, SystemRoot, HOMEDRIVE, USERPROFILE, TMP, CommonProgramFiles(x86), NUMBER_OF_PROCESSORS, IDEA_INITIAL_DIRECTORY, ANDROID_AVD_HOME]
2024-08-19T17:19:15.665+0300 [DEBUG] [org.gradle.launcher.daemon.server.SynchronizedDispatchConnection] thread 398: received class org.gradle.launcher.daemon.protocol.CloseInput
2024-08-19T17:19:15.665+0300 [DEBUG] [org.gradle.launcher.daemon.server.DefaultDaemonConnection] thread 398: Received IO message from client: org.gradle.launcher.daemon.protocol.CloseInput@69b414b8
2024-08-19T17:19:15.666+0300 [DEBUG] [org.gradle.launcher.daemon.server.exec.LogToClient] About to start relaying all logs to the client via the connection.
2024-08-19T17:19:15.666+0300 [INFO] [org.gradle.launcher.daemon.server.exec.LogToClient] The client will now receive all logging from the daemon (pid: 2512). The daemon log file: D:\ProjectForAndroid\daemon\8.7\daemon-2512.out.log
2024-08-19T17:19:15.666+0300 [INFO] [org.gradle.launcher.daemon.server.exec.LogAndCheckHealth] Starting 4th build in daemon [uptime: 39 mins 37.73 secs, performance: 100%, GC rate: 0.00/s, heap usage: 0% of 2 GiB]
2024-08-19T17:19:15.666+0300 [DEBUG] [org.gradle.launcher.daemon.server.exec.ExecuteBuild] The daemon has started executing the build.
2024-08-19T17:19:15.666+0300 [INFO] [org.gradle.launcher.daemon.server.exec.ForwardClientInput] Closing daemon's stdin at end of input.
2024-08-19T17:19:15.666+0300 [INFO] [org.gradle.launcher.daemon.server.exec.ForwardClientInput] The daemon will no longer process any standard input.
2024-08-19T17:19:15.666+0300 [DEBUG] [org.gradle.launcher.daemon.server.exec.ExecuteBuild] Executing build with daemon context: DefaultDaemonContext[uid=c8fea0f4-03cc-4104-8fa1-d4503aff3108,javaHome=D:\Android\jbr,daemonRegistryDir=D:\ProjectForAndroid\daemon,pid=2512,idleTimeout=10800000,priority=NORMAL,applyInstrumentationAgent=true,daemonOpts=--add-opens=java.base/java.util=ALL-UNNAMED,--add-opens=java.base/java.lang=ALL-UNNAMED,--add-opens=java.base/java.lang.invoke=ALL-UNNAMED,--add-opens=java.prefs/java.util.prefs=ALL-UNNAMED,--add-opens=java.base/java.nio.charset=ALL-UNNAMED,--add-opens=java.base/java.net=ALL-UNNAMED,--add-opens=java.base/java.util.concurrent.atomic=ALL-UNNAMED,-Xmx2048m,-Dfile.encoding=UTF-8,-Duser.country=RU,-Duser.language=ru,-Duser.variant]
w: file:///D:/Calculator/app/src/main/java/com/example/calculator/Output.kt:74:13 Variable 'bigDecimalCurrentNumber' is never used

Deprecated Gradle features were used in this build, making it incompatible with Gradle 9.0.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/8.7/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD SUCCESSFUL in 2s
15 actionable tasks: 1 executed, 14 up-to-date
2024-08-19T17:19:18.632+0300 [DEBUG] [org.gradle.launcher.daemon.server.exec.ExecuteBuild] The daemon has finished executing the build.
2024-08-19T17:19:18.637+0300 [DEBUG] [org.gradle.launcher.daemon.server.DaemonStateCoordinator] daemon is running. Sleeping until state changes.
2024-08-19T17:19:18.637+0300 [DEBUG] [org.gradle.launcher.daemon.server.DaemonStateCoordinator] Command execution: finished waiting for DaemonCommandExecution[command = Build{id=6b90ee28-74df-4015-9a06-c9e0ed9e96f8, currentDir=D:\Calculator}, connection = DefaultDaemonConnection: socket connection from /127.0.0.1:54011 to /127.0.0.1:61091]. Result org.gradle.launcher.daemon.server.DaemonStateCoordinator@26dca76b with state Busy
2024-08-19T17:19:18.637+0300 [DEBUG] [org.gradle.launcher.daemon.server.DaemonStateCoordinator] Command execution: completed DaemonCommandExecution[command = Build{id=6b90ee28-74df-4015-9a06-c9e0ed9e96f8, currentDir=D:\Calculator}, connection = DefaultDaemonConnection: socket connection from /127.0.0.1:54011 to /127.0.0.1:61091]
2024-08-19T17:19:18.637+0300 [DEBUG] [org.gradle.launcher.daemon.server.DaemonStateCoordinator] resetting idle timer
2024-08-19T17:19:18.637+0300 [INFO] [org.gradle.launcher.daemon.server.DaemonRegistryUpdater] Marking the daemon as idle, address: [7e94bee2-4324-41c4-b834-a5c93b483536 port:54011, addresses:[localhost/127.0.0.1]]
2024-08-19T17:19:18.637+0300 [DEBUG] [org.gradle.launcher.daemon.registry.PersistentDaemonRegistry] Marking busy by address: [7e94bee2-4324-41c4-b834-a5c93b483536 port:54011, addresses:[localhost/127.0.0.1]]
2024-08-19T17:19:18.638+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire exclusive lock on daemon addresses registry.
2024-08-19T17:19:18.638+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:19:18.639+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:19:18.639+0300 [DEBUG] [org.gradle.launcher.daemon.server.exec.ReturnResult] Daemon is dispatching the build result: Success[value=org.gradle.launcher.exec.BuildActionResult@287d369]
2024-08-19T17:19:18.639+0300 [DEBUG] [org.gradle.launcher.daemon.server.DaemonStateCoordinator] daemon is running. Sleeping until state changes.
2024-08-19T17:19:18.639+0300 [DEBUG] [org.gradle.launcher.daemon.server.SynchronizedDispatchConnection] thread 397: dispatching Success[value=org.gradle.launcher.exec.BuildActionResult@287d369]
2024-08-19T17:19:18.639+0300 [DEBUG] [org.gradle.launcher.daemon.server.DefaultIncomingConnectionHandler] Finishing executing command: Build{id=6b90ee28-74df-4015-9a06-c9e0ed9e96f8, currentDir=D:\Calculator}
2024-08-19T17:19:18.639+0300 [DEBUG] [org.gradle.launcher.daemon.server.exec.CleanUpVirtualFileSystemAfterBuild] Cleaning virtual file system after build finished
2024-08-19T17:19:18.639+0300 [DEBUG] [org.gradle.launcher.daemon.server.SynchronizedDispatchConnection] thread 398: received class org.gradle.launcher.daemon.protocol.Finished
2024-08-19T17:19:18.639+0300 [DEBUG] [org.gradle.launcher.daemon.server.DefaultDaemonConnection] thread 398: Received non-IO message from client: org.gradle.launcher.daemon.protocol.Finished@6773e7fe
2024-08-19T17:19:18.640+0300 [DEBUG] [org.gradle.launcher.daemon.server.DefaultIncomingConnectionHandler] Received finished message: org.gradle.launcher.daemon.protocol.Finished@6773e7fe
2024-08-19T17:19:18.640+0300 [DEBUG] [org.gradle.internal.remote.internal.inet.SocketConnection] Discarding EOFException: java.io.EOFException
2024-08-19T17:19:18.640+0300 [DEBUG] [org.gradle.launcher.daemon.server.SynchronizedDispatchConnection] thread 397: stopping connection
2024-08-19T17:19:18.640+0300 [DEBUG] [org.gradle.launcher.daemon.server.SynchronizedDispatchConnection] thread 398: received null
2024-08-19T17:19:18.640+0300 [DEBUG] [org.gradle.launcher.daemon.server.DefaultDaemonConnection] thread 398: Received end-of-input from client.
2024-08-19T17:19:18.640+0300 [DEBUG] [org.gradle.launcher.daemon.server.SynchronizedDispatchConnection] thread 397: stopping connection
2024-08-19T17:19:28.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:19:28.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:19:28.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:19:28.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:19:28.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:19:28.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:19:31.335+0300 [DEBUG] [sun.rmi.transport.tcp] RMI Scheduler(0): close connection, socket: Socket[addr=localhost/127.0.0.1,port=17655,localport=61095]
2024-08-19T17:19:38.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:19:38.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:19:38.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:19:38.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:19:38.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:19:38.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:19:38.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:19:38.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:19:38.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:19:46.337+0300 [DEBUG] [sun.rmi.transport.tcp] RMI TCP Connection(13)-127.0.0.1: accepted socket from [127.0.0.1:61212]
2024-08-19T17:19:46.337+0300 [DEBUG] [sun.rmi.transport.tcp] RMI Scheduler(0): close connection, socket: Socket[addr=localhost/127.0.0.1,port=17655,localport=61096]
2024-08-19T17:19:46.337+0300 [DEBUG] [sun.rmi.transport.tcp] RMI TCP Connection(13)-127.0.0.1: (port 54031) op = 80
2024-08-19T17:19:46.337+0300 [DEBUG] [sun.rmi.loader] RMI TCP Connection(13)-127.0.0.1: name = "[Ljava.rmi.server.ObjID;", codebase = "", defaultLoader = jdk.internal.loader.ClassLoaders$PlatformClassLoader@13891de3
2024-08-19T17:19:46.337+0300 [DEBUG] [sun.rmi.loader] RMI TCP Connection(13)-127.0.0.1: name = "java.rmi.dgc.Lease", codebase = "", defaultLoader = jdk.internal.loader.ClassLoaders$PlatformClassLoader@13891de3
2024-08-19T17:19:46.337+0300 [DEBUG] [sun.rmi.loader] RMI TCP Connection(13)-127.0.0.1: name = "java.rmi.dgc.VMID", codebase = "", defaultLoader = jdk.internal.loader.ClassLoaders$PlatformClassLoader@13891de3
2024-08-19T17:19:46.337+0300 [DEBUG] [sun.rmi.loader] RMI TCP Connection(13)-127.0.0.1: name = "[B", codebase = "", defaultLoader = jdk.internal.loader.ClassLoaders$PlatformClassLoader@13891de3
2024-08-19T17:19:46.337+0300 [DEBUG] [sun.rmi.loader] RMI TCP Connection(13)-127.0.0.1: name = "java.rmi.server.UID", codebase = "", defaultLoader = jdk.internal.loader.ClassLoaders$PlatformClassLoader@13891de3
2024-08-19T17:19:46.343+0300 [DEBUG] [sun.rmi.transport.tcp] RMI TCP Connection(12)-127.0.0.1: (port 58890) connection closed
2024-08-19T17:19:46.343+0300 [DEBUG] [sun.rmi.transport.tcp] RMI TCP Connection(12)-127.0.0.1: close connection, socket: Socket[addr=/127.0.0.1,port=61097,localport=58890]
2024-08-19T17:19:46.343+0300 [DEBUG] [sun.rmi.transport.tcp] RMI TCP Connection(12)-127.0.0.1: socket close: Socket[addr=/127.0.0.1,port=61097,localport=58890]
2024-08-19T17:19:48.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:19:48.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:19:48.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:19:48.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:19:48.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:19:48.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:19:48.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:19:48.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:19:48.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:19:58.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:19:58.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:19:58.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:19:58.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:19:58.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:19:58.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:19:58.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:19:58.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:19:58.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:20:01.339+0300 [DEBUG] [sun.rmi.transport.tcp] RMI TCP Connection(13)-127.0.0.1: (port 54031) connection closed
2024-08-19T17:20:01.339+0300 [DEBUG] [sun.rmi.transport.tcp] RMI TCP Connection(13)-127.0.0.1: close connection, socket: Socket[addr=/127.0.0.1,port=61212,localport=54031]
2024-08-19T17:20:01.339+0300 [DEBUG] [sun.rmi.transport.tcp] RMI TCP Connection(13)-127.0.0.1: socket close: Socket[addr=/127.0.0.1,port=61212,localport=54031]
2024-08-19T17:20:08.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:20:08.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:20:08.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:20:08.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:20:08.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:20:08.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:20:08.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:20:08.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:20:08.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:20:18.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:20:18.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:20:18.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:20:18.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:20:18.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:20:18.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:20:18.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:20:18.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:20:18.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:20:28.195+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:20:28.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:20:28.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:20:28.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:20:28.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:20:28.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:20:28.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:20:28.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:20:28.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:20:38.195+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:20:38.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:20:38.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:20:38.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:20:38.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:20:38.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:20:38.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:20:38.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:20:38.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:20:48.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:20:48.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:20:48.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:20:48.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:20:48.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:20:48.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:20:48.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:20:48.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:20:48.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:20:58.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:20:58.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:20:58.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:20:58.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:20:58.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:20:58.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:20:58.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:20:58.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:20:58.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:21:08.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:21:08.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:21:08.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:21:08.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:21:08.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:21:08.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:21:08.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:21:08.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:21:08.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:21:18.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:21:18.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:21:18.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:21:18.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:21:18.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:21:18.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:21:18.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:21:18.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:21:18.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:21:28.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:21:28.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:21:28.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:21:28.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:21:28.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:21:28.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:21:28.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:21:28.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:21:28.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:21:38.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:21:38.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:21:38.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:21:38.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:21:38.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:21:38.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:21:38.200+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:21:38.200+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:21:38.200+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:21:48.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:21:48.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:21:48.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:21:48.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:21:48.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:21:48.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:21:48.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:21:48.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:21:48.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:21:58.195+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:21:58.195+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:21:58.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:21:58.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:21:58.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:21:58.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:21:58.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:21:58.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:21:58.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:22:08.195+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:22:08.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:22:08.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:22:08.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:22:08.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:22:08.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:22:08.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:22:08.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:22:08.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:22:18.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:22:18.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:22:18.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:22:18.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:22:18.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:22:18.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:22:18.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:22:18.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:22:18.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:22:28.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:22:28.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:22:28.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:22:28.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:22:28.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:22:28.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:22:28.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:22:28.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:22:28.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:22:29.828+0300 [DEBUG] [sun.rmi.transport.tcp] RMI TCP Connection(14)-127.0.0.1: accepted socket from [127.0.0.1:61826]
2024-08-19T17:22:29.828+0300 [DEBUG] [sun.rmi.transport.tcp] RMI TCP Connection(14)-127.0.0.1: (port 58890) op = 80
2024-08-19T17:22:29.829+0300 [DEBUG] [sun.rmi.loader] RMI TCP Connection(14)-127.0.0.1: name = "[Ljava.rmi.server.ObjID;", codebase = "", defaultLoader = jdk.internal.loader.ClassLoaders$PlatformClassLoader@13891de3
2024-08-19T17:22:29.829+0300 [DEBUG] [sun.rmi.loader] RMI TCP Connection(14)-127.0.0.1: name = "java.rmi.dgc.Lease", codebase = "", defaultLoader = jdk.internal.loader.ClassLoaders$PlatformClassLoader@13891de3
2024-08-19T17:22:29.829+0300 [DEBUG] [sun.rmi.loader] RMI TCP Connection(14)-127.0.0.1: name = "java.rmi.dgc.VMID", codebase = "", defaultLoader = jdk.internal.loader.ClassLoaders$PlatformClassLoader@13891de3
2024-08-19T17:22:29.829+0300 [DEBUG] [sun.rmi.loader] RMI TCP Connection(14)-127.0.0.1: name = "[B", codebase = "", defaultLoader = jdk.internal.loader.ClassLoaders$PlatformClassLoader@13891de3
2024-08-19T17:22:29.829+0300 [DEBUG] [sun.rmi.loader] RMI TCP Connection(14)-127.0.0.1: name = "java.rmi.server.UID", codebase = "", defaultLoader = jdk.internal.loader.ClassLoaders$PlatformClassLoader@13891de3
2024-08-19T17:22:38.196+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:22:38.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:22:38.197+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:22:38.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:22:38.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:22:38.198+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:22:38.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Waiting to acquire shared lock on daemon addresses registry.
2024-08-19T17:22:38.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Lock acquired on daemon addresses registry.
2024-08-19T17:22:38.199+0300 [DEBUG] [org.gradle.cache.internal.DefaultFileLockManager] Releasing lock on daemon addresses registry.
2024-08-19T17:22:44.830+0300 [DEBUG] [sun.rmi.transport.tcp] RMI TCP Connection(14)-127.0.0.1: (port 58890) connection closed
2024-08-19T17:22