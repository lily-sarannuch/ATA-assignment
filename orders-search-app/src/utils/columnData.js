import { HourglassTwoTone } from "@ant-design/icons";
import { Space } from "antd";

export const columnName = [
  {
    title: "Account",
    dataIndex: "account",
    key: "account",
    sorter: (a, b) => a.account - b.account,
  },
  {
    title: "Operation",
    dataIndex: "operation",
    key: "operation",
    sorter: (a, b) => (a.operation > b.operation ? -1 : 1),
  },
  {
    title: "Symbol",
    dataIndex: "symbol",
    key: "symbol",
    sorter: (a, b) => (a.operation > b.operation ? -1 : 1),
  },
  {
    title: "Descripton",
    dataIndex: "description",
    key: "description",
    sorter: (a, b) => (a.operation > b.operation ? -1 : 1),
  },
  {
    title: "Quantity",
    dataIndex: "quantity",
    key: "quantity",
    sorter: (a, b) => (a.operation > b.operation ? -1 : 1),
  },
  {
    title: "Filled Quantity",
    dataIndex: "filledQuantity",
    key: "filledQuantity",
    sorter: (a, b) => a.account - b.account,
  },
  {
    title: "Price",
    dataIndex: "price",
    key: "price",
    sorter: (a, b) => a.account - b.account,
  },
  {
    title: "Status",
    dataIndex: "status",
    key: "status",
    render: () => (
      <Space size="small">
        <HourglassTwoTone /> Waiting
      </Space>
    ),
    sorter: (a, b) => (a.operation > b.operation ? -1 : 1),
  },
  {
    title: "Date",
    dataIndex: "date",
    key: "date",
  },
  {
    title: "Expiration",
    dataIndex: "expiration",
    key: "expiration",
  },
  {
    title: "No. Ref.",
    dataIndex: "refNo",
    key: "refNo",
    sorter: (a, b) => a.account - b.account,
  },
  {
    title: "Ext. Ref.",
    dataIndex: "extRef",
    key: "extRef",
    sorter: (a, b) => (a.operation > b.operation ? -1 : 1),
  },
  {
    title: "",
    dataIndex: "",
    render: () => <a>...</a>,
  },
];
