import React, { useEffect, useState } from "react";
import { mockOrdersData } from "../utils/mockData";
import { columnName } from "../utils/columnData";
import {
  Button,
  DatePicker,
  Flex,
  Select,
  Space,
  Table,
  Typography,
} from "antd";
import axios from "axios";
import MockAdapter from "axios-mock-adapter";

const { Text } = Typography;

// Create a mock adapter instance
const mock = new MockAdapter(axios);
// Mock a GET request to /api/users
mock.onGet("/api/orders").reply(200, mockOrdersData);

//Change
const handleChange = (value) => {
  console.log(`selected ${value}`);
};

const columns = columnName;
const search = {
  width: "35%",
  height: "auto",
};
const filter = {
  width: "65%",
  height: "auto",
};
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
    <Flex vertical>
      <Flex gap="small">
        <Flex style={search} justify="flex-start" align="center">
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
        </Flex>
        <Flex style={filter} justify="space-between" align="center">
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
          <Flex align="center">
            <Text strong style={inputHeader}>
              To
            </Text>
            <DatePicker onChange={onExpirationChange} allowClear />
          </Flex>
          <Button
            type="primary"
            shape="round"
            size="large"
            style={{ width: "12%" }}
            onClick={onSearch}
          >
            Search
          </Button>
        </Flex>
      </Flex>
      <Table columns={columns} dataSource={filterData()} />
    </Flex>
  );
};

export default OrderSearch;
