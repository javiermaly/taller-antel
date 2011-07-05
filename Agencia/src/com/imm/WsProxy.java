package com.imm;

public class WsProxy implements com.imm.Ws {
  private String _endpoint = null;
  private com.imm.Ws ws = null;
  
  public WsProxy() {
    _initWsProxy();
  }
  
  public WsProxy(String endpoint) {
    _endpoint = endpoint;
    _initWsProxy();
  }
  
  private void _initWsProxy() {
    try {
      ws = (new com.imm.WsServiceLocator()).getWsPort();
      if (ws != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)ws)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)ws)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (ws != null)
      ((javax.xml.rpc.Stub)ws)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.imm.Ws getWs() {
    if (ws == null)
      _initWsProxy();
    return ws;
  }
  
  public java.lang.String anulacion(java.lang.String arg0, java.lang.String arg1, int arg2) throws java.rmi.RemoteException{
    if (ws == null)
      _initWsProxy();
    return ws.anulacion(arg0, arg1, arg2);
  }
  
  public java.lang.String venta(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.util.Calendar arg3, int arg4) throws java.rmi.RemoteException{
    if (ws == null)
      _initWsProxy();
    return ws.venta(arg0, arg1, arg2, arg3, arg4);
  }
  
  
}