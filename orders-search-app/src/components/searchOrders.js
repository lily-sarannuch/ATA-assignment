import React, { useEffect, useState } from "react";
import { mockOrdersData } from "../utils/mockData";
import { DownOutlined } from "@ant-design/icons";
import { columnName, mobileColumns } from "../utils/columnData";
import {
  Button,
  Col,
  DatePicker,
  Flex,
  Grid,
  Row,
  Select,
  Space,
  Table,
  Typography,
} from "antd";
import axios from "axios";
import MockAdapter from "axios-mock-adapter";

const { Text } = Typography;
const { useBreakpoint } = Grid;

// Create a mock adapter instance
const mock = new MockAdapter(axios);
// Mock a GET request to /api/users
mock.onGet("/api/orders").reply(200, mockOrdersData);

//Change
const handleChange = (value) => {
  console.log(`selected ${value}`);
};

const columns = columnName;
const inputHeader = {
  margin: 0,
  color: "#336a8f",
  marginRight: "0.5rem",
};

const OrderSearch = () => {
  const [data, setData] = useState([]);
  const [filterInput, setFilterInput] = useState("");
  const [newDate, setNewDate] = useState("");
  const [newExpiration, setNewExpiration] = useState("");
  const screens = useBreakpoint();

  const onDateChange = (date, dateString) => {
    setNewDate(dateString);
  };
  const onExpirationChange = (date, dateString) => {
    setNewExpiration(dateString);
  };

  useEffect(() => {
    axios.get("/api/orders").then((response) => {
      setData(response.data);
    });
  }, []);

  const onSearch = () => {
    if (newDate !== "") {
      setFilterInput(newDate);
    } else if (newExpiration !== "") {
      setFilterInput(newExpiration);
    } else setFilterInput("");
  };

  const filterData = () => {
    if (filterInput === "") return data;

    if (isNaN(filterInput) && filterInput === newDate) {
      return data.filter(({ date }) => date.includes(newDate));
    }
    if (isNaN(filterInput) && filterInput === newExpiration) {
      return data.filter(({ expiration }) =>
        expiration.includes(newExpiration)
      );
    }
    return data;
  };

  return (
    <div>
      <Row gutter={[4, 4]} justify="space-between" align="middle">
        <Col xs={24} sm={12} md={8} lg={3}>
          <Space direction="vertical">
            <Typography.Title
              level={4}
              style={{
                margin: 0,
              }}
            >
              Search
            </Typography.Title>
            <Space>
              <Text type="secondary">Search results : </Text>
              <Text strong>{data.length}</Text>
            </Space>
          </Space>
        </Col>

        <Col xs={24} sm={12} md={8} lg={4}>
          <Flex align="center">
            <Text strong style={inputHeader}>
              Period
            </Text>
            <Select
              defaultValue="Transmission"
              style={{
                width: "auto",
              }}
              onChange={handleChange}
              options={[
                {
                  value: "Transmission",
                  label: "Transmission",
                },
              ]}
            />
          </Flex>
        </Col>

        <Col xs={24} sm={12} md={8} lg={4}>
          <Flex align="center">
            <Text strong style={inputHeader}>
              Status
            </Text>
            <Select
              defaultValue="Waiting"
              style={{
                width: "auto",
              }}
              onChange={handleChange}
              options={[
                {
                  value: "Waiting",
                  label: "Waiting",
                },
              ]}
            />
          </Flex>
        </Col>

        <Col xs={24} sm={12} md={8} lg={4}>
          <Flex align="center">
            <Text strong style={inputHeader}>
              From
            </Text>
            <DatePicker
              format="YYYY-MM-DD"
              onChange={onDateChange}
              allowClear
            />
          </Flex>
        </Col>

        <Col xs={24} sm={12} md={8} lg={4}>
          <Flex align="center">
            <Text strong style={inputHeader}>
              To
            </Text>
            <DatePicker onChange={onExpirationChange} allowClear />
          </Flex>
        </Col>

        <Col xs={24} sm={12} md={8} lg={4}>
          <Button type="primary" shape="round" size="large" onClick={onSearch}>
            Search
          </Button>
        </Col>
      </Row>
      <Table
        columns={screens.xs ? mobileColumns : columns}
        expandable={{
          expandedRowRender: (record) => (
            <Row justify="space-between" align="middle">
              <Col>
                <Flex>
                  <Typography.Title
                    level={5}
                    style={{
                      margin: 0,
                      marginRight: "8px",
                      color:'#2b84fd'
                    }}
                  >
                    FIRST-NAME LAST-NAME ( 10103ZA - US Margin)
                  </Typography.Title>
                  <Button iconPosition={"end"} shape="round"  style={{color:'#2b84fd'}}>
                    Full review details
                  </Button>
                </Flex>
              </Col>
              <Col>
                <Button
                  type="primary"
                  shape="round"
                  size={"Small"}
                  style={{
                    marginRight: "8px",
                  }}
                >
                  ACCEPT
                </Button>
                <Button shape="round" danger icon={<DownOutlined />} iconPosition="end" size={"Small"}>
                  Reject
                </Button>
              </Col>
            </Row>
            
          ),
        }}
        dataSource={filterData()}
      />
    </div>
  );
};

export default OrderSearch;
