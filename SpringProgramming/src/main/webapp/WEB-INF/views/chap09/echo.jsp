<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Apache Tomcat WebSocket Examples: Echo</title>
    <style type="text/css">
    	body {
			font-size: small;			
		}
		#connect-container {
            float: left;
            width: 400px
        }

        #connect-container div {
            padding: 5px;
        }

        #console-container {
            float: left;
            margin-left: 15px;
            width: 400px;
        }

        #console {
            border: 1px solid #CCCCCC;
            border-right-color: #999999;
            border-bottom-color: #999999;
            height: 170px;
            overflow-y: scroll;
            padding: 5px;
            width: 100%;
        }

        #console p {
            padding: 0;
            margin: 0;
        }
	</style>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
    	var ws = null;
    
    	function connect() {
 			ws = new WebSocket("ws://" + window.location.host + "/SpringProgramming/echo-ws");
 			
 			ws.onopen = function() {
 				log("접속되었습니다.");
 				setConnected(true);
 			};
 			
 			
 			ws.onclose = function() {
 				log("접속이 끊어졌습니다.");
 				setConnected(false);
 			};
 			
 			ws.onmessage = function(event) {
 				log(event.data);
 			}
 		}
    	
    	function disconnect() {
    		if(ws != null) {
    			ws.close();
    			ws = null;
    		}
    	}
    	
    	function echo() {
    		var message = $("#message").val();
    		ws.send(message);
    	}
    	
    	function setConnected(connected) {
    		if(connected) {
    			$("#connect").attr("disabled","disabled");
    			$("#disconnect").removeAttr("disabled");
    			$("#echo").removeAttr("disabled");
    		} else {    			
    			$("#connect").removeAttr("disabled");
    			$("#disconnect").attr("disabled","disabled");
    			$("#echo").attr("disabled", "disabled");
    		}    		
    	}  
    	
    	function log(message) {
    		$("#console").append("<span style='display:block'>" + message + "</span>");
    		if($("#console span").length>20) {
    			$("#console span").first().remove();
    		}
    		$("#console").scrollTop($("#console").height());    		
    	}
	</script>
</head>
<body>
	<!-- 언니 자리 또 뺏어서 미안해요..나는 무개념 힝 화이티이잉 XD  -->
    <div id="connect-container">
        <div>
            <button id="connect" onclick="connect();">Connect</button>
            <button id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button>
        </div>
        <div>
            <textarea id="message" style="width: 350px">Here is a message!</textarea>
        </div>
        <div>
            <button id="echo" onclick="echo();" disabled="disabled">Echo message</button>
        </div>
    </div>
    <div id="console-container">
        <div id="console"/>
    </div>
</body>
</html>