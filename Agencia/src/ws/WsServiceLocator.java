/**
 * WsServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws;

public class WsServiceLocator extends org.apache.axis.client.Service implements ws.WsService {

    public WsServiceLocator() {
    }


    public WsServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WsServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WsPort
    private java.lang.String WsPort_address = "http://localhost:8080/IMM/Ws";

    public java.lang.String getWsPortAddress() {
        return WsPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WsPortWSDDServiceName = "WsPort";

    public java.lang.String getWsPortWSDDServiceName() {
        return WsPortWSDDServiceName;
    }

    public void setWsPortWSDDServiceName(java.lang.String name) {
        WsPortWSDDServiceName = name;
    }

    public ws.Ws getWsPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WsPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWsPort(endpoint);
    }

    public ws.Ws getWsPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ws.WsBindingStub _stub = new ws.WsBindingStub(portAddress, this);
            _stub.setPortName(getWsPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWsPortEndpointAddress(java.lang.String address) {
        WsPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ws.Ws.class.isAssignableFrom(serviceEndpointInterface)) {
                ws.WsBindingStub _stub = new ws.WsBindingStub(new java.net.URL(WsPort_address), this);
                _stub.setPortName(getWsPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WsPort".equals(inputPortName)) {
            return getWsPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://imm.com/", "WsService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://imm.com/", "WsPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WsPort".equals(portName)) {
            setWsPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
